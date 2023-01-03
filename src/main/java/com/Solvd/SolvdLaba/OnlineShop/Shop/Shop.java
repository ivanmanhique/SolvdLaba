package com.Solvd.SolvdLaba.OnlineShop.Shop;



import com.Solvd.SolvdLaba.OnlineShop.Order.Exceptions.OrderNotFoundException;
import com.Solvd.SolvdLaba.OnlineShop.Order.Order;
import com.Solvd.SolvdLaba.OnlineShop.Order.OrderStatus;
import com.Solvd.SolvdLaba.OnlineShop.Payment.Payment;
import com.Solvd.SolvdLaba.OnlineShop.Person.Customer;
import com.Solvd.SolvdLaba.OnlineShop.Person.CustomerType;
import com.Solvd.SolvdLaba.OnlineShop.Product.Exceptions.OutOfStockException;
import com.Solvd.SolvdLaba.OnlineShop.Product.Exceptions.ProductNotFoundException;
import com.Solvd.SolvdLaba.OnlineShop.Product.Stock;
import com.Solvd.SolvdLaba.OnlineShop.Order.Interfaces.Orderable;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Shop implements Orderable{

    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private final String name;
    private LinkedList<Order> orders;
    private List<Stock> productList;


    public Shop(String name, List<Stock> productList){
        this.name = name;
        this.productList = productList;
        orders = new LinkedList<>();
    }

    public Shop(String name){
        this.name = name;
        productList = new ArrayList<>();
    }

    private void welcomeLog(){
        LOGGER.log(Level.INFO, String.format("Welcome to %s shop XD", name));
    }

    public void showWelcomeMessage(){
        welcomeLog();
        System.out.printf(
                "Welcome to our beloved %s" +
                        "\nBelow you can find all " +
                        "the available materials:\n", name
        );
    }

    public void warningLog(){
        LOGGER.log(Level.WARNING, "Dont forget to confirmOrder");
    }

    public String getName(){
        return name;
    }

    //public Order getOrder(){
     //   return order;
    //}

    public List<Stock> getProductList(){
        return productList;
    }

    public void setProductList(List<Stock> productList){
        this.productList = productList;
    }

    public void addProductToShop(Stock stock){
        productList.add(stock);
    }
    public void showGoodbyeMessage(){
        System.out.println("Thank you for visiting our shop\n" +
                "You will always be welcome\n" +
                "Best Wishes");
    }

    public void showProductsInShop(){
        productList.forEach(p -> System.out.printf("\t%s  %d\n", p.getProduct().getName(), p.getProduct().getPrice()));
    }

    public int createOrder(Customer customer){
        Order order = new Order(customer,this);
        orders.add(order);
        System.out.printf("Here is your orderId: %d\n", order.getOrderId());
        return order.getOrderId();
    }

    @Override
    public void cancelOrder(Customer customer, int orderId){
        for (Order order : customer.getOrders()){
            if(order.getOrderId() == orderId){
                order.setOrderStatus(OrderStatus.CANCELLED);
            }
        }
        System.out.println("Order was cancelled");
    }

    public Order searchOrder(int orderId){
        for(Order order: orders){
            if (order.getOrderId()==orderId){
                return order;
            }else{
                try{
                    throw new OrderNotFoundException(orderId);
                }catch (OrderNotFoundException e){
                    e.printStackTrace();
                }
            }
        }
        //Throw exception of order not found
        return null;
    }

    public void buy(int orderId, String nameOfProduct, int quantity){
        Stock product;
        boolean found = false;
        for (Stock stock : productList){
            if (stock.getProduct().getName().equalsIgnoreCase(nameOfProduct)){
                try{
                found = true;
                if (stock.getQuantity() < quantity){
                    throw new OutOfStockException(nameOfProduct, stock);
                } else{
                    product = new Stock(stock.getProduct(), quantity);
                    int quantityUpdate = stock.getQuantity() - quantity;
                    stock.setQuantity(quantityUpdate);
                    searchOrder(orderId).addItem(product);
                }
                }catch (OutOfStockException e){
                    e.printStackTrace();
                }
            }
        }
        if(!found){
            try{
                throw new ProductNotFoundException(this, nameOfProduct);
            }catch (ProductNotFoundException e){
                e.printStackTrace();
            }

        }
    }
    public void showUpdatedOrder(int orderId){
        System.out.println("an update of your order list:");
        searchOrder(orderId).showOrder();
        System.out.println(searchOrder(orderId).toString());
    }

    public CustomerType upgradeCustomer(int orderId){
        Order order = searchOrder(orderId);
        if (order.getTotal()>=200 && order.getTotal()<500){
            order.getCustomer().setCustomerType(CustomerType.INTERMEDIATE);
        } else if (order.getTotal()>=500){
            order.getCustomer().setCustomerType(CustomerType.PRO);
        }
        return order.getCustomer().getCustomerType();
    }
    private void applyDiscount(int orderId,CustomerType customerType){
        if(customerType == CustomerType.PRO){
            Order order = searchOrder(orderId);
            int tenPercent = (int) (order.getTotal()*0.1);
            order.setTotal(order.getTotal()-tenPercent);
        }else if (customerType == CustomerType.INTERMEDIATE){
            Order order = searchOrder(orderId);
            int fivePercent = (int) (order.getTotal()*0.05);
            order.setTotal(order.getTotal()-fivePercent);
        }
    }

    public void confirmOrder(int orderId,Payment payment){
        Order order = searchOrder(orderId);
        order.CalculateTotal();
        applyDiscount(orderId,upgradeCustomer(orderId));
        if (payment.pay(order.getTotal())){
            order.setOrderStatus(OrderStatus.CONFIRMED);
            System.out.println(order.getOrderStatus());
            System.out.println(payment.getPaymentStatus());
            System.out.println("Your order has been paid, below you can find your receipt");
            order.printReceipt();
        } else{
            System.out.println(payment.getPaymentStatus());
        }
    }


    @Override
    public int hashCode(){
        return this.hashCode();
    }

    @Override
    public boolean equals(Object obj){
        return this.equals(obj);
    }

    @Override
    public String toString(){
        return "Shop{" +
                "name='" + name + '\'' +
                ", productList=" + productList +
                ", order=" + //order +
                '}';
    }


}

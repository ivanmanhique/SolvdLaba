package com.Solvd.SolvdLaba.OnlineShop.Shop;



import com.Solvd.SolvdLaba.OnlineShop.Payment.Payment;
import com.Solvd.SolvdLaba.OnlineShop.Shop.Interfaces.Orderable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Shop implements Orderable{

    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private final String name;
    private Order order;
    private List<Stock> productList;


    public Shop(String name, List<Stock> productList){
        this.name = name;
        this.productList = productList;
    }

    public Shop(String name){
        this.name = name;
        productList = new ArrayList<>();
    }

    public void welcomeLog(){
        LOGGER.log(Level.INFO, String.format("Welcome to %s shop XD", name));
    }

    public void warningLog(){
        LOGGER.log(Level.WARNING, "Dont forget to confirmOrder");
    }

    public String getName(){
        return name;
    }

    public Order getOrder(){
        return order;
    }

    public List<Stock> getProductList(){
        return productList;
    }

    public void setProductList(List<Stock> productList){
        this.productList = productList;
    }

    public void addProductToShop(Stock stock){
        productList.add(stock);
    }
    public void goodbye(){
        System.out.println("Thank you for visiting our shop\n" +
                "You will always be welcome\n" +
                "Best Wishes");
    }

    public void showProductsInShop(){
        productList.stream()
                .forEach(p -> System.out.printf("%s  %d\n", p.getProduct().getName(), p.getProduct().getPrice()));
    }

    private void createOrder(){
        order = new Order();
    }

    @Override
    public void cancelOrder(){
        order = null;
        System.out.println("Order was cancelled");
    }

    public void buy(String nameOfProduct, int quantity){
        if(order == null){
            createOrder();
        }
        Stock product;
        for (Stock stock : productList){
            if (stock.getProduct().getName().equalsIgnoreCase(nameOfProduct)){
                product = new Stock(stock.getProduct(), quantity);
                int quantityUpdate = stock.getQuantity() - quantity;
                stock.setQuantity(quantityUpdate);
                order.addItem(product);
            }
        }
        System.out.println("an update of your order list:");
        order.showOrder();
    }

    public void confirmOrder(Payment payment){
        Receipt receipt = new Receipt(this, order);
        if (payment.pay(receipt.getTotal())){
            order.setPaid(true);
            System.out.println(payment.getPaymentStatus());
            System.out.println("Your order has been paid, below you can find your receipt");
            receipt.printReceipt();
        } else{
            System.out.println(payment.getPaymentStatus());
        }

    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shop shop = (Shop) o;
        return Objects.equals(name, shop.name) && Objects.equals(productList, shop.productList) && Objects.equals(order, shop.order);
    }

    @Override
    public int hashCode(){
        return Objects.hash(name, productList, order);
    }

    @Override
    public String toString(){
        return "Shop{" +
                "name='" + name + '\'' +
                ", productList=" + productList +
                ", order=" + order +
                '}';
    }


}

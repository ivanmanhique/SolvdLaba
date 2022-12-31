package com.Solvd.SolvdLaba.OnlineShop.Order;

import com.Solvd.SolvdLaba.OnlineShop.Product.Stock;

import java.util.ArrayList;
import java.util.List;

public class Order{

    private final List<Stock> productList;
    private OrderStatus orderStatus;

    public Order(){
        this.productList = new ArrayList<>();
        this.orderStatus = OrderStatus.CREATED;
    }

    public OrderStatus getOrderStatus(){
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus){
        this.orderStatus = orderStatus;
    }

    public List<Stock> getProductList(){
        return productList;
    }

    public void addItem(Stock product){
        productList.add(product);
    }

    public void removeItem(Stock product){
        if (!productList.remove(product)){
            System.out.println("no such Item");
        } else{
            System.out.println("removed!");
        }
    }


    public void showOrder(){
        StringBuilder sb = new StringBuilder();
        int counter = 1;
        for (Stock product : productList){
            sb.append(String.format("%d.  %s  %d  %d\n", counter, product.getProduct().getName(), product.getQuantity(), product.totalPerProduct()));
            counter++;
        }

        System.out.println(sb);
    }

}

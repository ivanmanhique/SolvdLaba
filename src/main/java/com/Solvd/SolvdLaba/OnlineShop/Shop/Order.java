package com.Solvd.SolvdLaba.OnlineShop.Shop;

import java.util.ArrayList;
import java.util.List;

public class Order{

    private final List<Stock> productList;
    private boolean isPaid = false;

    public Order(){
        this.productList = new ArrayList<>();

    }

    public boolean isPaid(){
        return isPaid;
    }

    public void setPaid(boolean paid){
        isPaid = paid;
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

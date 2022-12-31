package com.Solvd.SolvdLaba.OnlineShop.Order;

import com.Solvd.SolvdLaba.OnlineShop.Shop.Shop;
import com.Solvd.SolvdLaba.OnlineShop.Product.Stock;

import java.util.List;

public class Receipt{
    private final List<Stock> productList;
    private final Shop shop;
    private final Order order;
    private int total = 0;

    public Receipt(Shop shop, Order order){
        this.productList = order.getProductList();
        this.shop = shop;
        this.order = order;
    }

    public List<Stock> getProductList(){
        return productList;
    }

    public Shop getShop(){
        return shop;
    }

    public int getTotal(){
        for (Stock product : productList){
            total += ((long) product.getProduct().getPrice() * product.getQuantity());
        }

        return total;
    }

    public void printReceipt(){
        StringBuilder sb = new StringBuilder();
        int counter = 1;
        String title = String.format("\t%s\n", shop.getName());
        sb.append(title);
        sb.append("-----------------------------------------\n");
        for (Stock product : productList){
            sb.append(String.format("\t%d.  %s  %d  %d", counter, product.getProduct().getName(), product.getProduct().getPrice(), product.getQuantity()));
            sb.append("\n");
            counter++;
        }
        sb.append("\n");
        sb.append("-----------------------------------------\n");
        sb.append(String.format("\tTotal: %d\n\tPAID", getTotal()));

        System.out.println(sb);
    }
}

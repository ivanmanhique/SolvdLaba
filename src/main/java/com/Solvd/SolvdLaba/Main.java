package com.Solvd.SolvdLaba;



import com.Solvd.SolvdLaba.OnlineShop.Shipment.CustomExceptions.ShipmentNotPaidException;
import com.Solvd.SolvdLaba.OnlineShop.Order.Receipt;
import com.Solvd.SolvdLaba.OnlineShop.Payment.Payment;
import com.Solvd.SolvdLaba.OnlineShop.Person.Client;
import com.Solvd.SolvdLaba.OnlineShop.Person.Courier;
import com.Solvd.SolvdLaba.OnlineShop.Person.Entity;
import com.Solvd.SolvdLaba.OnlineShop.Product.Category;
import com.Solvd.SolvdLaba.OnlineShop.Product.Product;
import com.Solvd.SolvdLaba.OnlineShop.Product.Stock;
import com.Solvd.SolvdLaba.OnlineShop.Shipment.Shipment;
import com.Solvd.SolvdLaba.OnlineShop.Shop.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        RunShop();
    }

    public static void RunShop(){
        List<Stock> productList = new ArrayList<>();
        productList.add(new Stock(new Product("Chair", 50, Category.HOUSE), 50));
        productList.add(new Stock(new Product("Desk", 50, Category.HOUSE), 50));
        productList.add(new Stock(new Product("Pans", 50, Category.HOUSE), 50));
        productList.add(new Stock(new Product("A.C.", 50, Category.HOUSE), 50));
        productList.add(new Stock(new Product("Work Week", 100, Category.BOOKS), 50));
        productList.add(new Stock(new Product("Core Java", 100, Category.BOOKS), 50));
        productList.add(new Stock(new Product("No Rules", 100, Category.BOOKS), 50));
        productList.add(new Stock(new Product("Deep Work", 100, Category.BOOKS), 50));

        Shop shop = new Shop("ShopRight", productList);
        shop.welcomeLog();
        System.out.printf(
                "Welcome to our beloved %s" +
                        "\nBelow you can find all " +
                        "the available materials:\n", shop.getName()
        );
        shop.showProductsInShop();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to create an order? 1- for yes, 0 for no");
        int choice = scanner.nextInt();
        if (choice == 1){
            Client client = new Client("Ivan", "Manhique");
            System.out.println("Buy items:");
            shop.buy("Chair", 5);
            shop.buy("Desk", 3);
            String address = "Tchumene, Matola";
            Courier courier = new Courier("Joao", "Entregas");
            System.out.println("Pay for your order: ");
            Entity shopEntity = new Entity(shop.getName(), "Bank account");
            Receipt receipt = new Receipt(shop, shop.getOrder());
            Payment payment = new Payment(1234567, 123, "11/25", client, shopEntity, receipt, receipt.getTotal(), address);
            shop.confirmOrder(payment);
            try{
                Shipment shipment = new Shipment(address, courier, shop.getOrder(), shop);
                shipment.ship();
            } catch (ShipmentNotPaidException e){
                e.printStackTrace();
            }

        } else{
            shop.goodbye();
        }
    }
}
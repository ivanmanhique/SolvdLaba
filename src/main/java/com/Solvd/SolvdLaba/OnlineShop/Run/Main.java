package com.Solvd.SolvdLaba.OnlineShop.Run;



import com.Solvd.SolvdLaba.OnlineShop.Product.Files.ProductFile;
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

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        RunShop();
    }

    public static void RunShop(){
        List<Stock> productList = ProductFile.parse(Path.of("C:/Users/ivanm/IdeaProjects/SolvdLaba/src/main/java/com/Solvd/SolvdLaba/OnlineShop/Product/Files/ProductsFile").toFile());
        Shop shop = new Shop("ShopRight", productList);
        shop.showWelcomeMessage();
        shop.showProductsInShop();



        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to create an order?\n\t1- yes\n\t0- no");
        int choice = scanner.nextInt();
        if (choice == 1){
            System.out.println("Insert your name and surname");
            String clientName = scanner.next();
            String clientSurName = scanner.next();
            Client client = new Client(clientName, clientSurName);

            boolean stop = false;
            do{
                System.out.println("Which items would you like to buy? Insert its name and quantity");
                String productName = scanner.next();
                int productQuantity = scanner.nextInt();
                shop.buy(productName,productQuantity);

                System.out.println("If you want to buy more press 0, if not press one!");
                choice = scanner.nextInt();
                if (choice ==1){
                    stop = true;
                }
            } while (!stop);

            String address = "Tchumene, Matola";
            Courier courier = new Courier("Joao", "Entregas");
            System.out.println("Pay for your order: ");
            Entity shopEntity = new Entity(shop.getName(), "Bank account");
            Receipt receipt = new Receipt(shop, shop.getOrder());
            Payment payment = new Payment(1234567, 123, "11/25", client, shopEntity, receipt, receipt.getTotal(), address);
            shop.confirmOrder(payment);
            shop.showGoodbyeMessage();
            try{
                Shipment shipment = new Shipment(address, courier, shop.getOrder(), shop);
                shipment.ship();
            } catch (ShipmentNotPaidException e){
                e.printStackTrace();
            }

        } else{
            shop.showWelcomeMessage();
            shop.showProductsInShop();
            shop.showGoodbyeMessage();
        }
    }
}
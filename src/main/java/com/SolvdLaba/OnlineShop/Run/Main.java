package com.SolvdLaba.OnlineShop.Run;


import com.SolvdLaba.OnlineShop.Payment.Account;
import com.SolvdLaba.OnlineShop.Payment.AccountType;
import com.SolvdLaba.OnlineShop.Payment.Payment;
import com.SolvdLaba.OnlineShop.Person.Courier;
import com.SolvdLaba.OnlineShop.Person.Customer;
import com.SolvdLaba.OnlineShop.Product.Files.ProductFile;
import com.SolvdLaba.OnlineShop.Product.Stock;
import com.SolvdLaba.OnlineShop.Shipment.Shipment;
import com.SolvdLaba.OnlineShop.Shop.Shop;

import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        RunShop();
    }

    public static void RunShop(){

        List<Stock> productList = ProductFile.parse(Path.of("src/main/java/com/SolvdLaba/OnlineShop/Product/Files/ProductsFile").toFile());

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
            Customer customer = new Customer(clientName, clientSurName);
            int orderId = shop.createOrder(customer);

            boolean stop = false;
            do{
                System.out.println("Which items would you like to buy? Insert its name and quantity");
                String productName = scanner.next();
                int productQuantity = scanner.nextInt();
                shop.buy(orderId, productName, productQuantity);
                System.out.println("If you want to buy more press 0, if not press one!");
                choice = scanner.nextInt();
                if (choice == 1){
                    stop = true;
                }
            } while (!stop);
            System.out.println("An update on your order:");
            shop.showUpdatedOrder(orderId);

            String address = "Tchumene, Matola";
            System.out.println("Pay for your order: ");
            System.out.println("Provide your account:");

            Account account = new Account(12345, 123, "12/24", AccountType.VISA, 100);
            account.topUp(500);
            Payment payment = new Payment(account, customer, shop.searchOrder(orderId), address);
            shop.confirmOrder(orderId, payment);
            shop.showGoodbyeMessage();
            Shipment shipment = new Shipment("Matola", shop.searchOrder(orderId), shop);
            Courier courier = new Courier("Joao", "Entregas", "123-656-907");
            courier.addShipment(shipment);
            Shipment.ship(courier, shipment);

            System.out.println("How was your experience in the shop from 1-10");
            int rate = scanner.nextInt();
            Shop.clientShopRating(rate);
            scanner.close();
        } else{
            shop.showWelcomeMessage();
            shop.showProductsInShop();
            shop.showGoodbyeMessage();
            System.out.println("How was your experience in the shop from 1-10");
            int rate = scanner.nextInt();

            Shop.clientShopRating(rate);
            scanner.close();
        }
    }
}
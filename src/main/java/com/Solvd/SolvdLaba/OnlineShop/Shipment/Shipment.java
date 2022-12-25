package com.Solvd.SolvdLaba.OnlineShop.Shipment;


import com.Solvd.SolvdLaba.OnlineShop.Shipment.CustomExceptions.ShipmentNotPaidException;
import com.Solvd.SolvdLaba.OnlineShop.Person.Courier;
import com.Solvd.SolvdLaba.OnlineShop.Order.Order;
import com.Solvd.SolvdLaba.OnlineShop.Shop.Shop;

public class Shipment extends Delivery{
    private final Order order;
    private final Shop shop;

    public Shipment(String address, Courier courier, Order order, Shop shop) throws ShipmentNotPaidException{
        super(address, order, courier);
        try{
            if (!order.isPaid()) throw new Throwable();
            this.order = order;
        } catch (Throwable e){
            throw new ShipmentNotPaidException("Order is not paid", e);
        } finally{
            System.out.println("As soon as everything is set, we are going to start the shipment");
        }
        this.shop = shop;
    }

    public Order getOrder(){
        return order;
    }

    public Shop getShop(){
        return shop;
    }

    public void ship(){
        System.out.println("shipped");
    }
}

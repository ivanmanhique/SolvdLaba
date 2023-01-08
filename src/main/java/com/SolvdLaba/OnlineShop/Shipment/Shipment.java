package com.SolvdLaba.OnlineShop.Shipment;


import com.SolvdLaba.OnlineShop.Order.OrderStatus;
import com.SolvdLaba.OnlineShop.Shipment.CustomExceptions.ShipmentNotPaidException;
import com.SolvdLaba.OnlineShop.Person.Courier;
import com.SolvdLaba.OnlineShop.Order.Order;
import com.SolvdLaba.OnlineShop.Shop.Shop;

public class Shipment extends Delivery{
    private final Order order;
    private final Shop shop;

    public Shipment(String address, Courier courier, Order order, Shop shop){
        super(address, order, courier);
        this.order = order;
        this.shop = shop;
    }

    public static void ship(Shipment shipment){
        if(shipment.getOrder().getOrderStatus() == OrderStatus.CONFIRMED){
            System.out.printf("Order %d has been shipped", shipment.order.getOrderId());
        }else{
            try{
                throw new ShipmentNotPaidException(shipment);
            } catch (ShipmentNotPaidException e){
                e.printStackTrace();
            }
        }
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

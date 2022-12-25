package com.Solvd.SolvdLaba.OnlineShop.Shipment;

import com.Solvd.SolvdLaba.OnlineShop.Person.Courier;
import com.Solvd.SolvdLaba.OnlineShop.Order.Order;

public class Delivery{
    private final String address;
    private final Order order;
    private int deliveryPrice = 15;
    private final Courier courier;

    public Delivery(String address, Order order, Courier courier){
        this.address = address;
        this.order = order;
        this.courier = courier;
    }

    public Order getOrder(){
        return order;
    }

    public int getDeliveryPrice(){
        return deliveryPrice;
    }

    public void setDeliveryPrice(int deliveryPrice){
        this.deliveryPrice = deliveryPrice;
    }

    public String getAddress(){
        return address;
    }

    public Courier getCourier(){
        return courier;
    }
}

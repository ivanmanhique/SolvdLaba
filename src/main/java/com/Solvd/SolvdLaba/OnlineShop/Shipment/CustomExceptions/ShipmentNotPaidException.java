package com.Solvd.SolvdLaba.OnlineShop.Shipment.CustomExceptions;

public class ShipmentNotPaidException extends Exception{
    public ShipmentNotPaidException(String message, Throwable e){
        super(message, e);
    }
}

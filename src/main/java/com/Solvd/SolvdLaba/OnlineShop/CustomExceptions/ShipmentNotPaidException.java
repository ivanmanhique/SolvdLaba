package com.Solvd.SolvdLaba.OnlineShop.CustomExceptions;

public class ShipmentNotPaidException extends Exception{
    public ShipmentNotPaidException(String message, Throwable e){
        super(message, e);
    }
}

package com.Solvd.SolvdLaba.OnlineShop.Payment;


import com.Solvd.SolvdLaba.OnlineShop.Person.Person;
import com.Solvd.SolvdLaba.OnlineShop.Shop.Receipt;

public class Payment{
    private final long cardNumber;
    private final int threeNumBackCode;
    private final String expirationDate;
    private final Person sender;
    private final Person receiver;
    private PaymentStatus paymentStatus;
    private final Receipt receipt;
    private final int amount;
    private final String address;
    private int funds = 100000;

    public Payment(long cardNumber, int threeNumBackCode, String expirationDate, Person sender, Person receiver, Receipt receipt, int amount, String address){
        this.cardNumber = cardNumber;
        this.threeNumBackCode = threeNumBackCode;
        this.expirationDate = expirationDate;
        this.sender = sender;
        this.receiver = receiver;
        this.receipt = receipt;
        this.amount = amount;
        this.address = address;
    }

    public int getFunds(){
        return funds;
    }

    public boolean pay(int value){
        if (funds - value >= 0){
            funds -= value;
            paymentStatus = PaymentStatus.SUCCEEDED;
        } else{
            paymentStatus = PaymentStatus.REJECTED;
            return false;
        }
        return true;
    }

    public long getCardNumber(){
        return cardNumber;
    }

    public int getThreeNumBackCode(){
        return threeNumBackCode;
    }

    public String getExpirationDate(){
        return expirationDate;
    }

    public Person getSender(){
        return sender;
    }

    public Person getReceiver(){
        return receiver;
    }

    public PaymentStatus getPaymentStatus(){
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus){
        this.paymentStatus = paymentStatus;
    }

    public Receipt getReceipt(){
        return receipt;
    }

    public int getAmount(){
        return amount;
    }

    public String getAddress(){
        return address;
    }
}

package com.Solvd.SolvdLaba.OnlineShop.Payment;


import com.Solvd.SolvdLaba.OnlineShop.Order.Order;
import com.Solvd.SolvdLaba.OnlineShop.Payment.Exception.InsufficientFundsException;
import com.Solvd.SolvdLaba.OnlineShop.Person.Person;


public class Payment{
    private final long cardNumber;
    private final int threeNumBackCode;
    private final String expirationDate;
    private final Person sender;
    private final Person receiver;
    private PaymentStatus paymentStatus;
    private Order order;
    private final int amount;
    private final String address;
    private int funds ;

    public Payment(long cardNumber, int threeNumBackCode, String expirationDate, Person sender, Person receiver, Order receipt,String address, int funds){
        this.cardNumber = cardNumber;
        this.threeNumBackCode = threeNumBackCode;
        this.expirationDate = expirationDate;
        this.sender = sender;
        this.receiver = receiver;
        this.order = receipt;
        this.amount = receipt.getTotal();
        this.address = address;
        this.funds= funds;
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
            try{
                throw new InsufficientFundsException(this);
            }catch (InsufficientFundsException e){
                e.printStackTrace();
            }finally{
                return false;
            }

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

    public Order getReceipt(){
        return order;
    }

    public int getAmount(){
        return amount;
    }

    public String getAddress(){
        return address;
    }
}

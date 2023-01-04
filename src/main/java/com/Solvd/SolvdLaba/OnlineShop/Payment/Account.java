package com.Solvd.SolvdLaba.OnlineShop.Payment;

import com.Solvd.SolvdLaba.OnlineShop.Person.Person;

public class Account{

    private final long cardNumber;
    private final int threeNumBackCode;
    private final String expirationDate;
    private final AccountType accountType;
    private int funds;

    private Person user;

    public Account(long cardNumber, int threeNumBackCode, String expirationDate, AccountType accountType,int funds){
        this.cardNumber = cardNumber;
        this.threeNumBackCode = threeNumBackCode;
        this.expirationDate = expirationDate;
        this.accountType = accountType;
        this.funds = funds;
    }

    public Account(long cardNumber, int threeNumBackCode, String expirationDate, AccountType accountType, Person user){
        this.cardNumber = cardNumber;
        this.threeNumBackCode = threeNumBackCode;
        this.expirationDate = expirationDate;
        this.accountType = accountType;
        this.user = user;
    }

    public int getFunds(){
        return funds;
    }

    public AccountType getAccountType(){
        return accountType;
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

    public Person getUser(){
        return user;
    }

    public void setUser(Person user){
        this.user = user;
    }

    @Override
    public boolean equals(Object obj){
        return super.equals(obj);
    }
}

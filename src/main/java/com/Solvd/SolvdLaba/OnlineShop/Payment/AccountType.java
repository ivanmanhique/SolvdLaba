package com.Solvd.SolvdLaba.OnlineShop.Payment;

public enum AccountType{

    VISA("VISA"), MASTERCARD("MASTERCARD"), EXPRESS("EXPRESS");

    private String accountType;

    AccountType(String accountType){
        this.accountType = accountType;
    }

    public String getAccountType(){
        return accountType;
    }
}
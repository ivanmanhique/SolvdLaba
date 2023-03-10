package com.SolvdLaba.OnlineShop.Payment.Exception;

import com.SolvdLaba.OnlineShop.Payment.Account;

public class NonExistentAccount extends Exception{

    public NonExistentAccount(Account account){
        super(String.format("The account %s you are trying to use, doesnt exist", account.getCardNumber()));
    }
}

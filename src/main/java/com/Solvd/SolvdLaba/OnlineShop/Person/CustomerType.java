package com.Solvd.SolvdLaba.OnlineShop.Person;

public enum CustomerType{
    BASIC(0),INTERMEDIATE(200),PRO(500);
    private int leastAmountSpent;

    CustomerType(int leastAmountSpent){
        this.leastAmountSpent = leastAmountSpent;
    }
}

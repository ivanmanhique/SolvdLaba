package com.Solvd.SolvdLaba.OnlineShop.Shop;

public enum Category{
    HOUSE(2), BOOKS(1), ELECTRONICS(5);

    int attributedValue;

    Category(int attributedValue){
        this.attributedValue = attributedValue;
    }

    public int getAttributedValue(){
        return attributedValue;
    }

    public void setAttributedValue(int attributedValue){
        this.attributedValue = attributedValue;
    }
}

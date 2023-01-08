package com.SolvdLaba.OnlineShop.Shop;

public class InvalidRatingException extends Exception{

    public InvalidRatingException(int rate){
        super(String.format("The rating %d is not acceptable only ratings between [1-10]",rate));
    }
}

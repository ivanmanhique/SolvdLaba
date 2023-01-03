package com.Solvd.SolvdLaba.OnlineShop.Product.Exceptions;

import com.Solvd.SolvdLaba.OnlineShop.Shop.Shop;

public class ProductNotFoundException extends Exception{

    public ProductNotFoundException(Shop shop, String nameOfProduct){
        super(String.format("\nThe product '%s' is not available at %s shop", nameOfProduct, shop.getName()));
    }

}

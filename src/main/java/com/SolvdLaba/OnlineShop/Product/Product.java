package com.SolvdLaba.OnlineShop.Product;

public class Product implements Comparable<Product>{
    private static int nextProductId = 1;
    private final int productId;
    private final String name;
    private final int price;
    private final Category category;


    public Product(String name, int price, Category category){
        this.name = name;
        this.price = price;
        this.category = category;
        productId = nextProductId++;
    }

    public int getProductId(){
        return productId;
    }

    public String getName(){
        return name;
    }

    public int getPrice(){
        return price;
    }

    public Category getCategory(){
        return category;
    }


    @Override
    public int hashCode(){
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj){
        return super.equals(obj);
    }

    @Override
    public String toString(){
        return String.format("Name: %s, price: %d, codeNumber: %d", name, price, getProductId());
    }

    @Override
    public int compareTo(Product o){
        return this.category.compareTo(o.category);
    }
}

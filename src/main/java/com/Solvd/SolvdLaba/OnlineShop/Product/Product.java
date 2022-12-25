package com.Solvd.SolvdLaba.OnlineShop.Product;

public class Product implements Comparable<Product>{
    private static long idCounter = 0;
    private final String name;
    private final int price;
    private final Category category;


    public Product(String name, int price, Category category){
        this.name = name;
        this.price = price;
        this.category = category;
        idCounter = getIdCounter();
    }

    private static synchronized long getIdCounter(){
        return idCounter++;
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
        return String.format("Name: %s, price: %d, codeNumber: %d", name, price, idCounter);
    }

    @Override
    public int compareTo(Product o){
        return this.category.compareTo(o.category);
    }
}

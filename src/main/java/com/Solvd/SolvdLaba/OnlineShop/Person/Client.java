package com.Solvd.SolvdLaba.OnlineShop.Person;

public class Client extends Person{

    private static int nextCustomerId = 1;
    private final int customerId;

    public Client(String name, String surname){
        super(name, surname);
        this.customerId = nextCustomerId++;
    }

    public int getCustomerId(){
        return customerId;
    }

    @Override
    public String getName(){
        return super.getName();
    }

    @Override
    public String getSurname(){
        return super.getSurname();
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
        return String.format("%s %s(%d)", getName(),getSurname(), nextCustomerId);
    }
}

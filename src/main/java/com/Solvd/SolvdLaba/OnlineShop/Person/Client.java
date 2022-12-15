package com.Solvd.SolvdLaba.OnlineShop.Person;

public class Client extends Person{

    private static long idCounter = 0;

    public Client(String name, String surname){
        super(name, surname);
        this.idCounter = getIdCounter();
    }

    public static long getIdCounter(){
        return idCounter++;
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
        return String.format("%s %s(%d)", getName(),getSurname(), idCounter);
    }
}

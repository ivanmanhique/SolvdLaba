package com.Solvd.SolvdLaba.OnlineShop.Order.Interfaces;

import com.Solvd.SolvdLaba.OnlineShop.Person.Customer;

public interface Orderable{
    void cancelOrder(Customer customer, int orderId);

}

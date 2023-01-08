package com.SolvdLaba.OnlineShop.Order.Interfaces;

import com.SolvdLaba.OnlineShop.Person.Customer;
import com.SolvdLaba.OnlineShop.Product.Stock;

public interface Orderable{
    void cancelOrder(Customer customer, int orderId);
}

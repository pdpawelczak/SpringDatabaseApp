package com.SpringDatabaseApp.demo.piotr.service;

import com.SpringDatabaseApp.demo.piotr.model.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> getCustomers(Customer customer);
}

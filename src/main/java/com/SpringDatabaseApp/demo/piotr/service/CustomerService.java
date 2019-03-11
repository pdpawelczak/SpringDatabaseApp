package com.SpringDatabaseApp.demo.piotr.service;

import com.SpringDatabaseApp.demo.piotr.model.Customer;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomers(Customer customer);
    void saveCustomer(Customer customer);
    Sort sortByLastName(Customer customer);
    Customer getCustomer(int theId);
    void deleteCustomer(int theId);
    List<Customer> searchCustomers(String theSearchName);
}

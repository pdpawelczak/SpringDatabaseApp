package com.SpringDatabaseApp.demo.piotr.service;

import com.SpringDatabaseApp.demo.piotr.model.Customer;
import com.SpringDatabaseApp.demo.piotr.repository.CustomerRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    @Transactional
    public List<Customer> getCustomers(Customer customer) {
        return customerRepository.findAll();
    }
}

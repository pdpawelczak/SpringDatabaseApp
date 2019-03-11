package com.SpringDatabaseApp.demo.piotr.service;

import com.SpringDatabaseApp.demo.piotr.model.Customer;
import com.SpringDatabaseApp.demo.piotr.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    @Transactional
    public List<Customer> getCustomers(Customer customer) {
        return customerRepository.findAll(sortByLastName(customer));
    }

    @Override
    @Transactional
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    @Transactional
    public Sort sortByLastName(Customer customer) {
        return Sort.by("lastName");
    }

    @Override
    @Transactional
    public Customer getCustomer(int theId) {
        return customerRepository.getOne((long)theId);
    }

    @Override
    @Transactional
    public void deleteCustomer(int theId) {
        customerRepository.delete(getCustomer(theId));
    }

    @Override
    @Transactional
    public List<Customer> searchCustomers(String theSearchName) {

        //Musze zrobic zeby wyszukiwalo uzytkownika!!!
        if(theSearchName != null && theSearchName.trim().length() > 0){
            List<Customer> customers = customerRepository.findAll();
            return customers.stream().filter(customer -> customer.getFirstName().toLowerCase().contains(theSearchName.toLowerCase()) ||
                    customer.getLastName().toLowerCase().contains(theSearchName.toLowerCase()) ||
                    customer.getEmail().toLowerCase().contains(theSearchName.toLowerCase()))
            .collect(Collectors.toList());

        }
        else{
            return customerRepository.findAll();
        }
    }
}

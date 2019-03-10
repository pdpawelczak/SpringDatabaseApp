package com.SpringDatabaseApp.demo.piotr;

import com.SpringDatabaseApp.demo.piotr.model.Customer;
import com.SpringDatabaseApp.demo.piotr.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;



    @RequestMapping("/list")
    public String listCustomers(Model model, @ModelAttribute("customer") Customer customer
                                ){
        customerRepository.save(customer);
        model.addAttribute("customerList", customerRepository.findAll());
        return "list-customers";
    }
}

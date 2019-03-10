package com.SpringDatabaseApp.demo.piotr.controller;

import com.SpringDatabaseApp.demo.piotr.model.Customer;
import com.SpringDatabaseApp.demo.piotr.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    //CustomerRepository customerRepository;
    CustomerServiceImpl customerService;



    @RequestMapping("/list")
    public String processForm(Model model, @Valid @ModelAttribute("customer") Customer customer,
                              BindingResult theBindingResult){

            model.addAttribute("customerList", customerService.getCustomers(customer));
            return "list-customers";

    }

}

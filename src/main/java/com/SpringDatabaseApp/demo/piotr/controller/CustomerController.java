package com.SpringDatabaseApp.demo.piotr.controller;

import com.SpringDatabaseApp.demo.piotr.model.Customer;
import com.SpringDatabaseApp.demo.piotr.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerServiceImpl customerService;



    @GetMapping("/list")
    public String processForm(Model model, @Valid @ModelAttribute("customer") Customer customer,
                              BindingResult theBindingResult){

            model.addAttribute("customerList", customerService.getCustomers(customer));
            return "list-customers";

    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){

        //create model attribute to bind form data
        Customer customer = new Customer();
        model.addAttribute("customer", customer);

        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer){
        customerService.saveCustomer(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int theId, Model model){
        Customer customer = customerService.getCustomer(theId);
        model.addAttribute("customer", customer);
        return "customer-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("customerId") int theId){
        customerService.deleteCustomer(theId);
        return "redirect:/customer/list";
    }

    @GetMapping("/searchCustomer")
    public String searchCustomer(@RequestParam("theSearchName")String theSearchName, Model model){
        List<Customer> customers = customerService.searchCustomers(theSearchName);
        model.addAttribute("customerList", customers);
        return "list-customers";
    }

}

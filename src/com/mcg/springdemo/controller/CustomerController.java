package com.mcg.springdemo.controller;

import com.mcg.springdemo.dao.CustomerDAO;
import com.mcg.springdemo.entity.Customer;
import com.mcg.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model model){

        // get customers from the service
        List<Customer> customerList = customerService.getCustomers();

        //add the customers to the model
        model.addAttribute("customers",customerList);

        return "list-customers";
    }
}

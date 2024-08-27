package com.bookstore.api.controller;

import com.bookstore.api.entity.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private List<Customer> customerList = new ArrayList<>();

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        customerList.add(customer);
        return customer;
    }

    @PostMapping("/register")
    public String registerCustomer(@RequestParam String name, @RequestParam String email) {
        customerList.add(new Customer((long) (customerList.size() + 1), name, email));
        return "Customer registered successfully!";
    }
}

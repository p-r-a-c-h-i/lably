package com.xfactor.lably.controllers;

import java.util.ArrayList;
import java.util.List;


import com.xfactor.lably.entity.Customer;
import com.xfactor.lably.repository.CustomerRepository;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    ArrayList<Customer> customer = new ArrayList<>();

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/getCustomer")
    public ArrayList<Customer> getCustomer() {
        return customer;
    }

    @PostMapping("/addCustomer")
    public Customer addCustomer(@RequestBody Customer customer) {

        Customer persistedCustomer = customerRepository.save(customer);
        return persistedCustomer;
    }

    @GetMapping("/getAllCustomer")
    public List<Customer> getCustomers(){
        List<Customer> persistedCustomer = customerRepository.findAll();
        return persistedCustomer;
    }

    @GetMapping("/search")
    public ArrayList<Customer> searchAdmin(@RequestParam String name){

        ArrayList<Customer> ad= new ArrayList<>();
        boolean f = false;

        for(Customer a: customer){
            if(a.getName().equals(name)){
                f = true;
                ad.add(a);
            }              
        }
        if(f==true) return ad;
        else return null;
    }

}
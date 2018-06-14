package com.controller;

import com.model.Customer;
import com.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping("customers")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        var allCustomers = service.getAllCustomers();
        return new ResponseEntity<>(allCustomers,HttpStatus.OK);
    }

    @GetMapping("customers/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Integer id){
        var customerById = service.getCustomerById(id);
        return new ResponseEntity<>(customerById, HttpStatus.OK);

    }

    @PostMapping("customer")
    public ResponseEntity<Object> addCustomer(@RequestBody Customer customer){
        service.addCustomer(customer);
        return new ResponseEntity<>(service.getAllCustomers(), HttpStatus.CREATED);

    }

    @PutMapping("customer")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
        service.updateCustomer(customer);
        return new ResponseEntity<>(customer, HttpStatus.OK);

    }

    @DeleteMapping("customer/{id}")
    public ResponseEntity<List<Customer>> deleteCustomer(@PathVariable("id") Integer id){
        service.deleteCustomer(id);
        return new ResponseEntity<>(service.getAllCustomers(), HttpStatus.NO_CONTENT);
    }
}

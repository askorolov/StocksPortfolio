package com.service;

import com.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();
    void addCustomer(Customer customer);
    void deleteCustomer(int id);
    Customer getCustomerById(int id);
    void updateCustomer(Customer customer);
}

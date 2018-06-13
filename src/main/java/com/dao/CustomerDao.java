package com.dao;

import com.model.Customer;

import java.util.List;

    public interface CustomerDao {

    List<Customer> getAllCustomers();

    Customer getCustomerById(int id);

    void updateCustomer(Customer customer);

    void deleteCustomer (int id);

    void addCustomer(Customer customer);
}

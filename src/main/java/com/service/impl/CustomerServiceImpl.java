package com.service.impl;

import com.dao.CustomerDao;
import com.model.Customer;
import com.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.validation.Validator;

import java.util.List;

@Service
@CacheConfig(cacheNames = "customers")
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private Validator validator;

    @Override
    @Cacheable
    public List<Customer> getAllCustomers() {
        return customerDao.getAllCustomers();
    }

    @Override
    @CacheEvict(allEntries = true)
    public synchronized void addCustomer(Customer customer) {
        customerDao.addCustomer(customer);

    }

    @Override
    @CacheEvict(allEntries = true)
    public void deleteCustomer(int id) {
        customerDao.deleteCustomer(id);

    }

    @Override
    @Cacheable
    public Customer getCustomerById(int id) {
        return customerDao.getCustomerById(id);
    }

    @Override
    @CacheEvict(allEntries = true)
    public void updateCustomer(Customer customer) {
        customerDao.updateCustomer(customer);

    }
}

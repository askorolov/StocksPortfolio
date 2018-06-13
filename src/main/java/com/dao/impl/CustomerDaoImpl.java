package com.dao.impl;

import com.dao.CustomerDao;
import com.model.Customer;
import org.springframework.stereotype.Repository;

import javax.cache.annotation.CacheValue;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional(value = Transactional.TxType.REQUIRED)
public class CustomerDaoImpl implements CustomerDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Customer> getAllCustomers() {
        var hq = "from Customer as customer ORDER BY customer.name";
        return entityManager.createQuery(hq).getResultList();
    }

    @Override
    public Customer getCustomerById(int id) {
        return entityManager.find(Customer.class, id);
    }

    @Override
    @Transactional()
    public void updateCustomer(@CacheValue Customer customer) {
        entityManager.merge(customer);

    }


    @Override
    public void deleteCustomer(int id) {
        entityManager.remove(getCustomerById(id));
    }

    @Override
    public void addCustomer(Customer customer) {
        entityManager.persist(customer);
    }
}

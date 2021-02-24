package com.project.hms.service;

import com.project.hms.model.Customer;

import java.util.List;

public interface CustomerService {
    void saveCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(int id);
    Customer getCustomer(int id);
    List<Customer> getAllCustomer();
}

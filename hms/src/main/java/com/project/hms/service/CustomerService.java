package com.project.hms.service;

import com.project.hms.model.Customer;
import com.project.hms.model.Otp;

import java.util.List;

public interface CustomerService {
    void saveCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(int id);
    Customer getCustomer(int id);
    Customer getCustomer(String username);
    List<Customer> getAllCustomer();
    void updatePhone(Customer customer, String phone);

    void auth(Customer customer);
    boolean check(Otp otpToValidate);
}

package com.project.hms.service;

import com.project.hms.model.Customer;
import com.project.hms.repository.CustomerRepository;
import com.project.hms.util.PasswordUtil;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    @Override
    public void saveCustomer(Customer customer) {
        //encode password
        /*String password = PasswordUtil.encodePassword(customer.getPassword());
        customer.setPassword(password);*/
        customerRepository.save(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        /*String password = PasswordUtil.encodePassword(customer.getPassword());
        customer.setPassword(password);*/
        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(int id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer getCustomer(int id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public List<Customer> getAllCustomer() {
        return (List<Customer>) customerRepository.findAll();
    }
}

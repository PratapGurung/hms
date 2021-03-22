package com.project.hms.service;

import com.project.hms.model.Customer;
import com.project.hms.model.Otp;
import com.project.hms.repository.CustomerRepository;
import com.project.hms.repository.OtpRepository;
import com.project.hms.util.GenerateCodeUtil;
import com.project.hms.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private OtpRepository otpRepository;
    @Qualifier("passwordEncoder1")
    @Autowired
    private PasswordEncoder passwordEncoder;
    private final CustomerRepository customerRepository;
    public CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    @Override
    public void saveCustomer(Customer customer) {
        //encode password
        String password = PasswordUtil.encodePassword(customer.getPassword());
        customer.setPassword(password);
        customerRepository.save(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
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
    public Customer getCustomer(String username) {
        return customerRepository.findByUsername(username).get();
    }

    @Override
    public List<Customer> getAllCustomer() {
        return (List<Customer>) customerRepository.findAll();
    }

    @Override
    public void updatePhone(Customer customer, String phone) {
        customer.setPhone(phone);
        customerRepository.save(customer);
    }

    public void auth(Customer customer){
        Optional<Customer> o = customerRepository.findByUsername(customer.getUsername());
        if(o.isPresent()){
            Customer c = o.get();
            if(passwordEncoder.matches(customer.getPassword(),c.getPassword())){
                renewOtp(c);
            }
            else {
                throw new BadCredentialsException("Bad Credentials.");
            }
        }
    }

    private void renewOtp(Customer c) {
        String code = GenerateCodeUtil.generateCode();
        Optional<Otp> customerOtp = otpRepository.findOtpByUsername(c.getUsername());
        if(customerOtp.isPresent()){
            Otp otp = customerOtp.get();
            otp.setCode(code);
        }
        else {
            Otp otp = new Otp();
            otp.setUsername(c.getUsername());
            otp.setCode(code);
            otpRepository.save(otp);
        }

    }

    public boolean check(Otp otpToValidate){
        Optional<Otp> customerOtp = otpRepository.findOtpByUsername(otpToValidate.getUsername());
        if(customerOtp.isPresent()){
            Otp otp = customerOtp.get();
            if(otpToValidate.getCode().equals(otp.getCode())){
                return true;
            }
        }
        return false;
    }

}

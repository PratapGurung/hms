package com.project.hms.service;

import com.project.hms.model.Customer;
import com.project.hms.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class CustomCustomerServiceImpl implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Customer customer = customerRepository.findByUsername(username).get();
        if(customer == null){
            throw  new UsernameNotFoundException("Customer Not found!!!");
        }
        return new org.springframework.security.core.userdetails.User(customer.getUsername(),
                customer.getPassword(), true, true,true, true,
                getAuthorities(customer.getRole().getRoleName()));
    }

    public Collection<? extends SimpleGrantedAuthority> getAuthorities(String roleName){
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(roleName));
        return authorities;
    }
}

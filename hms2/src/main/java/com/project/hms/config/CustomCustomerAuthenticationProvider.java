/*
package com.project.hms.config;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import javax.annotation.Resource;
import java.util.Arrays;


public class CustomCustomerAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = String.valueOf(authentication.getCredentials());
        if("john".equals(username) && "12345".equals(password)){
            return new UsernamePasswordAuthenticationToken(username,password, Arrays.asList());
        }
        else{
            throw new AuthenticationCredentialsNotFoundException("Credentials do not match!");
        }
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
*/

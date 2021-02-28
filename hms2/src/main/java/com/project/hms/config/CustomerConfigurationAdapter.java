package com.project.hms.config;

import com.project.hms.service.CustomCustomerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@Order(2)
public class CustomerConfigurationAdapter extends WebSecurityConfigurerAdapter {
    @Bean
    public UserDetailsService userDetailsService1(){
        return new CustomCustomerServiceImpl();
    }
    @Bean
    public PasswordEncoder passwordEncoder1(){
        return  new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService1()).passwordEncoder(passwordEncoder1());
    }


    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                /*.antMatcher("/login/customer/**")*/
                .authorizeRequests()
                .antMatchers("/resources/**", "/customer/signup/**").permitAll()
                .antMatchers("/customer/**").hasAuthority("customer")
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/customer/login")
                .defaultSuccessUrl("/customer/home", true)
                .permitAll()
                .and().logout().logoutUrl("/customer/logout").logoutSuccessUrl("/customer/login");

        http.csrf().disable();


    }

}

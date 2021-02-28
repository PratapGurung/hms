package com.project.hms.config;

import com.project.hms.service.CustomEmployeeServiceImpl;
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
@Order(1)
public class EmployeeConfigurationAdapter extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService2(){
        return new CustomEmployeeServiceImpl();
    }

    @Bean
    public PasswordEncoder passwordEncoder2(){
        return  new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService2()).passwordEncoder(passwordEncoder2());
    }


    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                /*.antMatcher("/login/employee/**")*/
                .authorizeRequests()
                .antMatchers("/employee/**").hasAnyAuthority("employee")
                .antMatchers("/resources/**", "/employee/signup/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/employee/login")
                .defaultSuccessUrl("/employee/home", true).permitAll()
                .and()
                .logout().logoutUrl("/employee/logout").logoutSuccessUrl("/employee/login");
        http.csrf().disable();

    }


}

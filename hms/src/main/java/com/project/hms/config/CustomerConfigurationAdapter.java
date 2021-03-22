package com.project.hms.config;

import com.project.hms.controller.RefererRedirectionAuthenticationSuccessHandler;
import com.project.hms.repository.CustomCsrfTokenRepository;
import com.project.hms.service.CustomCustomerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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

    @Bean
    public CsrfTokenRepository customTokenRepository(){
        return  new CustomCsrfTokenRepository();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService1()).passwordEncoder(passwordEncoder1());
    }


    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.cors(c -> {
            CorsConfigurationSource source = request -> {
                CorsConfiguration config = new CorsConfiguration();
                config.setAllowedOrigins(
                        List.of("example.com", "example.org", "http://localhost:9085"));
                config.setAllowedMethods(
                        List.of("GET", "POST", "PUT", "DELETE")
                );
                return config;
            };
            c.configurationSource(source);
        });
        http
                .antMatcher("/customer/**")

                .authorizeRequests()
                .antMatchers("/customer/pages/**").hasAuthority("customer")
                .antMatchers("/resources/**", "/customer/signup/**").permitAll()
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/customer/login")
                .defaultSuccessUrl("/customer/pages/home", true)
                .permitAll()
                .and().logout().logoutUrl("/customer/logout").logoutSuccessUrl("/customer/login")
                .and()
                .exceptionHandling().accessDeniedPage("/customer/accessdenied");
        /*
        http.csrf(c -> {
            c.csrfTokenRepository(customTokenRepository());
        })*/
        http.csrf().disable();


    }

}

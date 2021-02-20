package com.project.hms.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @RequestMapping("/")
    public ModelAndView defaultHome() {
        return new ModelAndView("home");
    }

    @RequestMapping("/home")
    public ModelAndView home() {
        return new ModelAndView("home");
    }

    @RequestMapping("/customer")
    public ModelAndView customer() {
        return new ModelAndView("customer/login");
    }
    @RequestMapping("/customer/login")
    public ModelAndView login() {
        return new ModelAndView("customer/login");
    }

    @RequestMapping("/customer/home")
    public ModelAndView customerHome() {
        System.out.println("hello");
        if (!isAuthenticated()) {
            return new ModelAndView("redirect:customer/login");
        }
        else{
            return new ModelAndView("customer/home");
        }

    }

    @RequestMapping("/employee")
    public ModelAndView employee() {
        return new ModelAndView("employee/login");
    }

    @RequestMapping("/employee/login")
    public ModelAndView employeelogin() {
        return new ModelAndView("employee/login");
    }


    @RequestMapping("/employee/home")
    public ModelAndView employeehome() {
        if (!isAuthenticated()) {
            return new ModelAndView("redirect:employee/login");
        }

        return new ModelAndView("employee/home");
    }


    private boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || AnonymousAuthenticationToken.class.
                isAssignableFrom(authentication.getClass())) {
            return false;
        }
        return authentication.isAuthenticated();
    }
}

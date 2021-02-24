package com.project.hms.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    /*
        Customer login controller
     */
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
    public ModelAndView clogin() {

        return new ModelAndView("customer/login");
    }


    @RequestMapping("/customer/pages/home")
    public ModelAndView customerHome() {
        return new ModelAndView("customer/pages/home");
    }


    /*
        employee login controller
     */
    @RequestMapping("/employee")
    public ModelAndView employee() {
        return new ModelAndView("/employee/login");
    }

    @RequestMapping("/employee/login")
    public ModelAndView employeelogin() {
        return new ModelAndView("/employee/login");
    }


    @RequestMapping("/employee/pages/home")
    public ModelAndView employeehome() {
        return new ModelAndView("employee/pages/home");
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

package com.project.hms.controller;

import com.project.hms.model.Otp;
import com.project.hms.service.CustomerService;
import com.project.hms.model.Customer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

@RestController
public class CustomerController {

    private CustomerService customerService;
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }


   @PostMapping("/add_customer")
    public String getCustomerForm(@RequestBody Customer customer){
        customerService.saveCustomer(customer);
        return "addCustomer";
    }

    @GetMapping("/edit_customer")
    public String getEditCustomerForm(@RequestParam int id, Model model){
        model.addAttribute("customer", customerService.getCustomer(id));
        return "editCustomer";
    }

    @PostMapping("/auth")
    public void auth(@RequestBody Customer customer){
        customerService.auth(customer);
    }

    @PostMapping("otp/check")
    public void check(@RequestBody Otp otp, HttpServletResponse response){
        if(customerService.check(otp)){
            System.out.println("hello it worked");
            response.setStatus((HttpServletResponse.SC_OK));
        }else {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }
    }
    @PostMapping("/save_customer")
    public String saveCustomer(@ModelAttribute Customer customer){
        customerService.saveCustomer(customer);
        return "redirect:/list_customer";
    }

    @PostMapping("/customer/update_customer")
    public String updateCustomer(@ModelAttribute Customer customer){
        customerService.updateCustomer(customer);
        return "redirect:/customer/pages/home";
    }

    @GetMapping("/list_customer")
    public String getAllCustomer(Model model){
        model.addAttribute("customers", customerService.getAllCustomer());
        return "listCustomer";
    }
    @GetMapping("/delete_customer")
    public String deleteCustomer(@RequestParam int id){
        customerService.deleteCustomer(id);
        return "redirect:/list_customer";
    }
    @GetMapping("/customer/signup")
    public ModelAndView customerSignUp() {
        return new ModelAndView("customer/signup");
    }

   @RequestMapping("/customer/edit/phone")
    public String changePhone(Model model){
       Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       Customer customer = customerService.getCustomer(authentication.getName());
       model.addAttribute("customer", customer);
       return "customer/pages/changePhone";
    }

    @RequestMapping("/customer/update/phone")
    public String updatePhone(@RequestParam("phone") String phone,Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Customer customer = customerService.getCustomer(authentication.getName());
        model.addAttribute("customer", customer);
        System.out.println(phone);
        customerService.updatePhone(customer,phone);
        return "redirect:/customer/pages/home";
    }

}

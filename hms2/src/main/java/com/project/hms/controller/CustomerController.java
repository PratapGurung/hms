package com.project.hms.controller;

import com.project.hms.service.CustomerService;
import com.project.hms.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {

    private CustomerService customerService;
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping("/add_customer")
    public String getCustomerForm(){
        return "addCustomer";
    }

    @GetMapping("/edit_customer")
    public String getEditCustomerForm(@RequestParam int id, Model model){
        model.addAttribute("customer", customerService.getCustomer(id));
        return "editCustomer";
    }

    @PostMapping("/save_customer")
    public String saveCustomer(@ModelAttribute Customer customer){
        customerService.saveCustomer(customer);
        return "redirect:/list_customer";
    }

    @PostMapping("/update_customer")
    public String updateCustomer(@ModelAttribute Customer customer){
        customerService.updateCustomer(customer);
        return "redirect:/list_customer";
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
}

package com.project.hms.controller;

import com.project.hms.model.Employee;
import com.project.hms.model.Role;
import com.project.hms.repository.RoleRepository;
import com.project.hms.service.EmployeeService;
import com.project.hms.service.RoleServiceImpl;
import com.project.hms.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {
    @Autowired
    private RoleServiceImpl roleService;
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }


    @GetMapping("/add_employee")
    public String getemployeeForm(){
        return "addEmployee";
    }

    @GetMapping("/edit_employee")
    public String getEditemployeeForm(@RequestParam int id, Model model){
        model.addAttribute("employee", employeeService.getEmployee(id));
        return "editEmployee";
    }

    @PostMapping("/save_employee")
    public String saveemployee(@ModelAttribute Employee employee){
        employeeService.saveEmployee(employee  );
        return "redirect:/employee/login";
    }

    @PostMapping("/update_employee")
    public String updateemployee(@ModelAttribute Employee employee){
        employeeService.updateEmployee(employee);
        return "redirect:/list_employee";
    }

    @GetMapping("/list_employee")
    public String getAllemployee(Model model){
        model.addAttribute("employees", employeeService.getAllEmployee());
        return "listemployee";
    }
    @GetMapping("/delete_employee")
    public String deleteemployee(@RequestParam int id){
        employeeService.deleteEmployee(id);
        return "redirect:/list_employee";
    }

    /*@GetMapping("/employee/signup")
    public String employeeSignUp() {
        return "employee/singup";
    }*/

    @GetMapping("/employee/signup")
    public ModelAndView employeeSignUp(Model model) {
        model.addAttribute("roles",roleService.getAllRole());
        return new ModelAndView("employee/signup")  ;
    }


}

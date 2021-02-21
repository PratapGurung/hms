package com.project.hms.service;

import com.project.hms.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService {
    void saveEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(int id);
    Employee getEmployee(int id);
    List<Employee> getAllEmployee();
    List<Employee> getAllEmployeeToManage(String username);
}

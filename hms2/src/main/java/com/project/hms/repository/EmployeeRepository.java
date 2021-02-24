package com.project.hms.repository;

import com.project.hms.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findByUsername(String username);

    @Query("SELECT e FROM Employee e WHERE e.reportsTo = ?1")
    Collection<Employee> findEmployeeToManage(String username);
}

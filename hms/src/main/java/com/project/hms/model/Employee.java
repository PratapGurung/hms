package com.project.hms.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue
    private int employeeId;
    private String username;
    private String password;
    private String lastName;
    private String firstName;
    private String phone;
    private String email;
    private String addressLine;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private LocalDate hiredDate;
    @OneToOne
    private Role role;
    @Transient
    private int roleId;
    /*@DateTimeFormat(pattern = "MM-dd-yyyy")
    private LocalDate lastPayDate;
    private int hrsWorkPerWeek;*/
}

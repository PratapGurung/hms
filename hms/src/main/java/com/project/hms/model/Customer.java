package com.project.hms.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "customers")
@Data
public class Customer {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String addressLine;
    private String city;
    private String state;
    private String postalCode;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateJoined;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate lastReservationDate;

    @OneToOne
    private Role role;


}

package com.project.hms.model;

import lombok.Data;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "otp")
public class Otp {
    @Id
    private String username;
    private String code;
}

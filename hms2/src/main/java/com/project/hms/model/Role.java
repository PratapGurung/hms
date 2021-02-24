package com.project.hms.model;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "role")
@Data
public class Role {
    @Id
    @GeneratedValue
    private int id;
    private String roleName;
    private int salaryPerHr;
}

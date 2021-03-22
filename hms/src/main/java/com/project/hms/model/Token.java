package com.project.hms.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "csrf")
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String identifier;
    private String token;

}

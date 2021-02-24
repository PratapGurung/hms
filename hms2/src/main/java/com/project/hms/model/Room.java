package com.project.hms.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue
    private int roomId;
    private int roomNumber;
    private Boolean available;
}

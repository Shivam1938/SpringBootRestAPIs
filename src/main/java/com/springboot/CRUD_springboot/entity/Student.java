package com.springboot.CRUD_springboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data
public class Student {

    @Id()
    private Long id;

    private String name;
    private int age;
    private String email;
    private int rollNo;
    private String subject;
}

package com.arikaran.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="emp_name")
    private String name;
    @Column(name="salary_emp")
    private int sal;
}

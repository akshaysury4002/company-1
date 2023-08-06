package com.as.company.domain;



import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

     @Column(name = "email")
    private String email;

    @Column(name = "DOB")
    private LocalDate dob;

    @Column(name = "age")
    private double age;

    @Column(name = "sal")
    private double sal;

    @Column(name = "status")
    private String empStatus;

    
}

package com.as.company.dto;

import java.time.LocalDate;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
public class EmployeeDto {
    
    private long id;

    @NotEmpty(message = "name cant be empty")
    @NotNull(message = "name cant be null")
    @NotBlank(message = "name cant be blank")
    private String name;

    @NotEmpty(message = "email cant be empty")
    @NotNull(message = "email cant be null")
    @NotBlank(message = "email cant be blank")
    private String email;
   
    @NotEmpty(message = "DOB cant be empty")
    @NotNull(message = "DOB cant be null")
    @NotBlank(message = "DOB cant be blank")
    private LocalDate dob;

    @NotEmpty(message = "age cant be empty")
    @NotNull(message = "age cant be null")
    @NotBlank(message = "age cant be blank")
    private double age;

    @NotEmpty(message = "salary cant be empty")
    @NotNull(message = "salary cant be null")
    @NotBlank(message = "salary cant be blank")
    private double sal;

    @NotEmpty(message = "empStatus cant be empty")
    @NotNull(message = "empStatus cant be null")
    @NotBlank(message = "empStatus cant be blank")
    private String empStatus;

  


}

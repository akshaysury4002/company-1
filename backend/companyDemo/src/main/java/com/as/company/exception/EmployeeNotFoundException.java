package com.as.company.exception;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(String msg)
    {
        super("User Not Found");
    }
    
}

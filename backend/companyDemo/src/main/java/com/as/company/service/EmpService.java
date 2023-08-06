package com.as.company.service;


import java.util.List;
import com.as.company.dto.EmployeeDto;
import com.as.company.exception.EmployeeNotFoundException;


public interface EmpService {

    Integer createNewUser(EmployeeDto emp);

    List<EmployeeDto> all();

    Integer deleteEmp(Long id) throws EmployeeNotFoundException;

    Integer updateEmp(EmployeeDto dto);

    EmployeeDto fetchEmpDetails(Long id) throws EmployeeNotFoundException;

   
}

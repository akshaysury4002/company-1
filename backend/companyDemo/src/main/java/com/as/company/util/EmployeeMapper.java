package com.as.company.util;


import org.springframework.stereotype.Component;

import com.as.company.domain.Employee;
import com.as.company.dto.EmployeeDto;

@Component
public class EmployeeMapper {

    public Employee toDomain(EmployeeDto dto)
    {
        return new Employee(dto.getId(),dto.getName(),dto.getEmail(),dto.getDob(),dto.getAge(),dto.getSal(), dto.getEmpStatus());
        
    }

   public EmployeeDto toDto(Employee domain)
    {
        return new EmployeeDto(domain.getId(),domain.getName(),domain.getEmail(),domain.getDob(),domain.getAge(),domain.getSal(), domain.getEmpStatus());
    }




    
}

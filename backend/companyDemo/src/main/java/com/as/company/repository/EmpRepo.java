package com.as.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.as.company.domain.Employee;


public interface EmpRepo extends JpaRepository<Employee, Long> {
    
}

package com.as.company.service;


import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.as.company.domain.Employee;
import com.as.company.dto.EmployeeDto;
import com.as.company.exception.EmployeeNotFoundException;
import com.as.company.repository.EmpRepo;

import com.as.company.util.EmployeeMapper;


import lombok.AllArgsConstructor;

@Transactional
@AllArgsConstructor
@Service
public class EmpServiceImpl implements EmpService {

    private final EmpRepo repository;
    private final EmployeeMapper mapper;
    //private final DynamicMapper dynamicMapper;

    @Override
    public Integer createNewUser(EmployeeDto emp) {

        repository.save(mapper.toDomain(emp));
        return 1;

    }

   
    @Override
    public List<EmployeeDto> all() {
        return repository.findAll()
                .stream()
                // .map( invoice -> mapper.toDto(invoice) )
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }


    @Override
    public Integer deleteEmp(Long id) {
        repository.deleteById(id);
        return 1;
    }

    @Override
    public Integer updateEmp(EmployeeDto emp) {
        repository.save(mapper.toDomain(emp));
       return 1;
    }


    @Override
    public EmployeeDto fetchEmpDetails(Long id) throws EmployeeNotFoundException {
        Optional<Employee> op = repository.findById(id);
        return mapper.toDto(op.orElseThrow(() -> new EmployeeNotFoundException("EmpId " + id + " Not Found")));
    }

    


}

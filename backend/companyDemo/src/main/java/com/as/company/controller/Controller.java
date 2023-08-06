package com.as.company.controller;

import java.util.List;



import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.as.company.dto.AppResponse;
import com.as.company.dto.EmployeeDto;
import com.as.company.service.EmpService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RequestMapping(value = "/company")
@RestController
public class Controller {

    private final EmpService service;



    @CrossOrigin
    @PostMapping(value = "/createEmp", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<Integer>> createNewUser(@RequestBody EmployeeDto dto)
    {
       final Integer sts= service.createNewUser(dto);

       final AppResponse<Integer> response= AppResponse.<Integer>builder()
                                                   .sts("success")
                                                   .msg("User created Succesfully")
                                                   .bd(sts)
                                                   .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    

    @CrossOrigin
    @GetMapping(value = "/getemployee", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<List<EmployeeDto>>> allUsers() {
        List<EmployeeDto> users = service.all();

        AppResponse<List<EmployeeDto>> response = AppResponse.<List<EmployeeDto>>builder()
                                                            .sts("success")
                                                            .msg("users")
                                                            .bd(users)
                                                            .build();

        return ResponseEntity.ok().body(response);
    }

    @CrossOrigin
    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<Integer>> deleteEmp(@PathVariable Long id) {

        final Integer sts = service.deleteEmp(id);

        final AppResponse<Integer> response = AppResponse.<Integer>builder()
            .sts("success")
            .msg("employee Deleted Successfully")
            .bd(sts)
            .build();

        return ResponseEntity.status(200).body(response);
    }


    @CrossOrigin
    @PutMapping(value = "/updateEmp", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<Integer>> updateEmp(@RequestBody EmployeeDto dto) {

        final Integer sts = service.updateEmp(dto);

        final AppResponse<Integer> response = AppResponse.<Integer>builder()
                                                    .sts("success")
                                                    .msg("Employee Updated Successfully")
                                                    .bd(sts)
                                                    .build();

        return ResponseEntity.ok().body(response);
    }

    @CrossOrigin
    @GetMapping(value = "/getEmpbyid/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<AppResponse<EmployeeDto>> getEmpById(@PathVariable Long id) {

        final EmployeeDto dto = service.fetchEmpDetails(id);

        final AppResponse<EmployeeDto> response = AppResponse.<EmployeeDto>builder()
                                                        .sts("success")
                                                        .msg("booking Details")
                                                        .bd(dto)
                                                        .build();
        return ResponseEntity.ok().body(response);
    }


    
}

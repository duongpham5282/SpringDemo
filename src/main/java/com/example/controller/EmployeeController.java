package com.example.controller;

import com.example.dto.PartialData;
import com.example.model.Employee;
import com.example.repository.IEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;


@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {


    @Autowired
    IEmployee employeeService;

    @GetMapping(path="/", produces = "application/json")
    public ResponseEntity<Optional<PartialData>> employee() {
        Optional<PartialData> emp = employeeService.findByName(1L);
        return ResponseEntity.ok(emp);
    }
}


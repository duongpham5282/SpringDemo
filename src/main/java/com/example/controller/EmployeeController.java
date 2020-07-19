package com.example.controller;

import com.example.model.Employee;
import com.example.model.Skill;
import com.example.repository.IEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {


    @Autowired
    IEmployee employeeService;

    @GetMapping(path="/", produces = "application/json")
    public ResponseEntity<Optional<Employee>> employee() {
        Optional<Employee> emp = employeeService.findById(1L);
        Collection<Skill> s = emp.get().getSkills();
        return ResponseEntity.ok(emp);
    }
}


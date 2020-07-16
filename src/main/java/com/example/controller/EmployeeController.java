package com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
    @GetMapping(path="/", produces = "application/json")
    public ResponseEntity<String> employee() {
        return new ResponseEntity<String>("aaaa", HttpStatus.OK);
    }
}

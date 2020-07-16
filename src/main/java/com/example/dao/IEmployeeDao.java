package com.example.dao;

import com.example.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeDao extends JpaRepository<Employee, Long> {

}

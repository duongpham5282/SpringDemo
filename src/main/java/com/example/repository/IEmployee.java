package com.example.repository;

import com.example.dto.PartialData;
import com.example.model.Employee;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface IEmployee extends JpaRepository<Employee, Long> {
    @Override
    @EntityGraph(attributePaths = {"skills.cources"})
    Optional<Employee> findById(Long id);

    @Query(value="SELECT e.id, e.name as empName, s.name as skillName FROM Employee e LEFT JOIN Skill s on e.id = s.emp_id WHERE e.id=:id",nativeQuery = true)
    Optional<PartialData> findByName(@Param("id") Long id);
}

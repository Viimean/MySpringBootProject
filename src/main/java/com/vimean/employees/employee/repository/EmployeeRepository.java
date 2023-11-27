package com.vimean.employees.employee.repository;

import com.vimean.employees.employee.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Integer> {
    EmployeeEntity save(EmployeeEntity emp);
    Optional<EmployeeEntity> findById(EmployeeEntity req);

}

package com.vimean.employees.employee.services;

import com.vimean.employees.employee.entity.EmployeeEntity;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<EmployeeEntity> employees();
    EmployeeEntity saveEmp(EmployeeEntity emp);
    Optional<EmployeeEntity> findByID(EmployeeEntity req) throws Exception;


}

package com.vimean.employees.employee.controller;
import com.vimean.employees.employee.entity.EmployeeEntity;
import com.vimean.employees.employee.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
   @Autowired
   EmployeeService empServices;

    @GetMapping
    public List<EmployeeEntity> employees(){
        return empServices.employees();
    }

    @GetMapping("/{id}")
    public Optional<EmployeeEntity> getEmpById(@PathVariable("id") int id){
        return empServices.getEmpById(id);
    };
}

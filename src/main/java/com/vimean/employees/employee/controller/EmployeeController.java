package com.vimean.employees.employee.controller;
import com.vimean.employees.employee.dto.ResponsePayload;
import com.vimean.employees.employee.entity.EmployeeEntity;
import com.vimean.employees.employee.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    public EmployeeService empServices;

    @GetMapping
    public List<EmployeeEntity> employees() {
        return empServices.employees();
    }

    /*--- Method insert emp ---*/
    @PostMapping("/add")
    public EmployeeEntity addEmpToDB(@RequestBody EmployeeEntity req) {
        EmployeeEntity createEmp = empServices.saveEmp(req);
        return createEmp;
    }

    /*--- Method findByID emp ---*/
    @PostMapping("/find")
    public ResponseEntity<ResponsePayload> findById(@RequestBody EmployeeEntity req) {
        try {
            req.getId();
            Optional<EmployeeEntity> empInfo = empServices.findByID(req);
            if (empInfo != null){
                ResponsePayload responsePayload = new ResponsePayload("SUC-001","Account exist");
                return new ResponseEntity<>(responsePayload, HttpStatus.OK);
            }
        }catch (Exception e){
            System.out.println(e);
            ResponsePayload responsePayload = new ResponsePayload(e);
            return new ResponseEntity<>(responsePayload, HttpStatus.BAD_REQUEST);
        }
        return null;

    }
}

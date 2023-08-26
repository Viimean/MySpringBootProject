package com.vimean.employees.employee.services.imp;

import com.vimean.employees.employee.entity.EmployeeEntity;
import com.vimean.employees.employee.repository.EmployeeRepository;
import com.vimean.employees.employee.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    private final EmployeeRepository empRepo;

    public EmployeeServiceImp(EmployeeRepository empRepo) {
        this.empRepo = empRepo;
    }

    @Override
    public List<EmployeeEntity> employees() {
        return empRepo.findAll();
    }
}

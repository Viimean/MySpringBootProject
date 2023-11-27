package com.vimean.employees.employee.services.imp;

import com.vimean.employees.employee.dto.request.ExternalReq;
import com.vimean.employees.employee.dto.response.ExternalRes;
import com.vimean.employees.employee.entity.EmployeeEntity;
import com.vimean.employees.employee.external.Provider;
import com.vimean.employees.employee.repository.EmployeeRepository;
import com.vimean.employees.employee.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    private final EmployeeRepository empRepo;
    /*--- Import Provider ---*/
    @Autowired
    private final Provider provider;

    public EmployeeServiceImp(EmployeeRepository empRepo, Provider provider) {
        this.empRepo = empRepo;
        this.provider = provider;
    }

    @Override
    public List<EmployeeEntity> employees() {
        return empRepo.findAll();
    }

    @Override
    public EmployeeEntity saveEmp(EmployeeEntity emp) {
        return empRepo.save(emp);
    }

    @Override
    public Optional<EmployeeEntity> findByID(EmployeeEntity req) throws Exception{
        /*--- If service success you can create to db  ---*/
        EmployeeEntity emp = new EmployeeEntity();
        emp.setReqPayload();
        ExternalReq externalReq = new ExternalReq();
        externalReq.setErrReq();
        ExternalRes login = provider.exService(externalReq);
        /*--- Check if success ---*/
        if (login == null){
            System.out.println("null case: ");
            throw new Exception("Error not found!");
        }else if (emp.getDepartment() == null){
            throw new Exception("Missing mandatory");
        }
        /*--- Second service---*/

        Optional<EmployeeEntity> empInfo = empRepo.findById(req.getId());
        System.out.println(empInfo);
        return empInfo;

    }
}

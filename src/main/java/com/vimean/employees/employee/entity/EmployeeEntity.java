package com.vimean.employees.employee.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Employees")
@Data
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMP_NO")
    private int id;

    @Column(name = "EMP_NAME")
    private String name;

    @Column(name = "EMP_POS")
    private String pos;

    @Column(name = "EMP_DEP")
    private String department;

    public EmployeeEntity(){

    }

    public EmployeeEntity(int id, String name, String pos, String department){
        this.id=id;
        this.name=name;
        this.pos= pos;
        this.department=department;
    }

    public void setReqPayload(){
        this.id= 199;
        this.name= "ssads";
        this.pos= "ssasd";
        this.department= "sadsad";
    }
}

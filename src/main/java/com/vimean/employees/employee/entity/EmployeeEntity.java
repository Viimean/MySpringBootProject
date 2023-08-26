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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public EmployeeEntity(){

    }

    public EmployeeEntity(int id, String name, String pos, String department){
        this.id=id;
        this.name=name;
        this.pos= pos;
        this.department=department;
    }
}

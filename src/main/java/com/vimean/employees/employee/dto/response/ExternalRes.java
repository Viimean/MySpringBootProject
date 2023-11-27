package com.vimean.employees.employee.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class ExternalRes {
    private String token;
    private String id;
    private String error;
}

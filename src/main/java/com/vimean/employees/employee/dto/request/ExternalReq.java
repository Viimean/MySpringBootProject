package com.vimean.employees.employee.dto.request;

import lombok.Data;

@Data
public class ExternalReq {
    private String email;
    private String password;

    /*-- Set errReq --*/
    public void setErrReq (){
        this.email = "well";
        this.password = "play";
    }

    /*-- Set sucReq --*/
    public void setSucReq (){
        this.email = "eve.holt@reqres.in";
        this.password = "pistol";
    }
}

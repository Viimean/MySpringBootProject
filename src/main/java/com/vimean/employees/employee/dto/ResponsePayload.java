package com.vimean.employees.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponsePayload {
    private Object status;
    private Object data;

    public ResponsePayload (Exception e){
        if (e.getMessage() == "Missing mandatory"){
            status status = new status();
            dataObject dataObject = new dataObject();
            status.setNotFound();
            this.status = status;
            this.data = dataObject;
        }else if (e.getMessage() == "Error not found!"){
            status obj = new status();
            dataObject dataObject = new dataObject();
            obj.setNotFoundReal();
            this.status = obj;
            this.data = dataObject;
        }else {
            System.out.println("Internal server error");
        }
    }


    @Data
    private class status{
        int code;
        String errorCode;
        String errorMessage;

        void setNotFound(){
            this.code = 3;
            this.errorCode = "ERR-003";
            this.errorMessage = "No account found.";
        }

        void setNotFoundReal(){
            this.code = 6;
            this.errorCode = "ERR-006";
            this.errorMessage = "Missing mandatory element.";

        }
    }


    @Data
    private class dataObject {
        String accessToken;
        String requireOtp;
        String requireChangePhone;
        String last3DigitsPhone;
    }
}

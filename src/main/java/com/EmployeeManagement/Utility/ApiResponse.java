package com.EmployeeManagement.Utility;


import java.beans.JavaBean;

@JavaBean
public class ApiResponse {

    public boolean Status;

    public String SystemMessage;

    public String CustomMessage;

    public Object Data;

    public ApiResponse() {
        this.Status=true;
        this.SystemMessage="";
        this.CustomMessage="";
        this.Data=null;
    }

    public ApiResponse(boolean status, String systemMessage, String customMessage, Object data) {

        Status = status;
        SystemMessage = systemMessage;
        CustomMessage = customMessage;
        Data = data;
    }

    public ApiResponse(boolean status, String systemMessage) {
        Status = status;
        SystemMessage = systemMessage;
    }
}

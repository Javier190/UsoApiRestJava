package com.example.usoapirestjava;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
//API
public class EmployeeResponse {

    @SerializedName("status") private String status;
    @SerializedName("data") private List<Employee> data;
    @SerializedName("message") private String message;

    public EmployeeResponse(String status, List<Employee> data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Employee> getData() {
        return data;
    }

    public void setData(List<Employee> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

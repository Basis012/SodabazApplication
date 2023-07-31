package com.sodabazapplication;

import com.google.gson.annotations.SerializedName;

public class Login_ModelClass {
       String status;
       String method;

    public Login_ModelClass(String status, String method) {
        this.status = status;
        this.method = method;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}

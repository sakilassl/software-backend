package com.ndex.service.productservice.productservice.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "registerd_customer")
public class RegCustomerModel<string> {
    @Id
    private String SID;

    public String getSID() {
        return SID;
    }

    public void setSID(String SID) {
        this.SID = SID;
    }

    private String user_name;
    private String email;
    private String FName;
    private String LName;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFName() {
        return FName;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public String getLName() {
        return LName;
    }

    public void setLName(String LName) {
        this.LName = LName;
    }
}

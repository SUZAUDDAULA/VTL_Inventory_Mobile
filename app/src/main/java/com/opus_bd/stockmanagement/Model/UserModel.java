package com.opus_bd.stockmanagement.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserModel {

    @SerializedName("Name")
    @Expose
    private String iD;
    @SerializedName("Password")
    @Expose
    private String password;

    public UserModel(String iD, String password) {
        this.iD = iD;
        this.password = password;
    }

    public String getID() {
        return iD;
    }

    public void setID(String iD) {
        this.iD = iD;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

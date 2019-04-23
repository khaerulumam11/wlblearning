package com.wlb.framework.learning.data.model.api.wlb.register;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegisterRequest {
    @Expose
    @SerializedName("name")
    private String name;
    @Expose
    @SerializedName("password")
    private String password;
    @Expose
    @SerializedName("email")
    private String email;

    public RegisterRequest(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

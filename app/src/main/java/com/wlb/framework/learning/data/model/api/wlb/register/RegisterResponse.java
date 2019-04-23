package com.wlb.framework.learning.data.model.api.wlb.register;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public  class RegisterResponse {
    @Expose
    @SerializedName("user_files")
    private String user_files;
    @Expose
    @SerializedName("avatar")
    private String avatar;
    @Expose
    @SerializedName("biography")
    private String biography;
    @Expose
    @SerializedName("socialLinks")
    private String socialLinks;
    @Expose
    @SerializedName("dateAdded")
    private String dateAdded;
    @Expose
    @SerializedName("lastModified")
    private String lastModified;
    @Expose
    @SerializedName("name")
    private String name;
    @Expose
    @SerializedName("email")
    private String email;
    @Expose
    @SerializedName("status")
    private String status;
    @Expose
    @SerializedName("latestBalance")
    private int latestBalance;
    @Expose
    @SerializedName("roles")
    private String roles;
    @Expose
    @SerializedName("id")
    private String id;

    public String getUser_files() {
        return user_files;
    }

    public void setUser_files(String user_files) {
        this.user_files = user_files;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getSocialLinks() {
        return socialLinks;
    }

    public void setSocialLinks(String socialLinks) {
        this.socialLinks = socialLinks;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getLatestBalance() {
        return latestBalance;
    }

    public void setLatestBalance(int latestBalance) {
        this.latestBalance = latestBalance;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

package com.wlb.framework.learning.data.model.api.wlb.account;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public  class LoginResponseWlb {
    @Expose
    @SerializedName("token")
    private String token;
    @Expose
    @SerializedName("oauth")
    private OauthEntity oauth;
    @Expose
    @SerializedName("status")
    private String status;
    @Expose
    @SerializedName("saltRounds")
    private int saltRounds;
    @Expose
    @SerializedName("lastModified")
    private String lastModified;
    @Expose
    @SerializedName("dateAdded")
    private String dateAdded;
    @Expose
    @SerializedName("latestBalance")
    private int latestBalance;
    @Expose
    @SerializedName("roles")
    private String roles;
    @Expose
    @SerializedName("biography")
    private String biography;
    @Expose
    @SerializedName("socialLinks")
    private String socialLinks;
    @Expose
    @SerializedName("email")
    private String email;
    @Expose
    @SerializedName("name")
    private String name;
    @Expose
    @SerializedName("id")
    private String id;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public OauthEntity getOauth() {
        return oauth;
    }

    public void setOauth(OauthEntity oauth) {
        this.oauth = oauth;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getSaltRounds() {
        return saltRounds;
    }

    public void setSaltRounds(int saltRounds) {
        this.saltRounds = saltRounds;
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static class OauthEntity {
        @Expose
        @SerializedName("url")
        private String url;
        @Expose
        @SerializedName("refresh_token")
        private String refresh_token;
        @Expose
        @SerializedName("expires_in")
        private int expires_in;
        @Expose
        @SerializedName("token_type")
        private String token_type;
        @Expose
        @SerializedName("access_token")
        private String access_token;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getRefresh_token() {
            return refresh_token;
        }

        public void setRefresh_token(String refresh_token) {
            this.refresh_token = refresh_token;
        }

        public int getExpires_in() {
            return expires_in;
        }

        public void setExpires_in(int expires_in) {
            this.expires_in = expires_in;
        }

        public String getToken_type() {
            return token_type;
        }

        public void setToken_type(String token_type) {
            this.token_type = token_type;
        }

        public String getAccess_token() {
            return access_token;
        }

        public void setAccess_token(String access_token) {
            this.access_token = access_token;
        }
    }
}

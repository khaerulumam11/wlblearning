package com.wlb.framework.learning.data.model.api.wlb.course;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * getCourse Primary
 * List<>
 */
public class ReviewRespMdl {


    @Expose
    @SerializedName("data")
    private List<Data> data;
    @Expose
    @SerializedName("total")
    private int total;
    @Expose
    @SerializedName("pages")
    private int pages;

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public static class Data {
        @Expose
        @SerializedName("Student")
        private Student Student;
        @Expose
        @SerializedName("user_id")
        private String user_id;
        @Expose
        @SerializedName("course_id")
        private int course_id;
        @Expose
        @SerializedName("reviewText")
        private String reviewText;
        @Expose
        @SerializedName("rating")
        private int rating;
        @Expose
        @SerializedName("completionRate")
        private int completionRate;
        @Expose
        @SerializedName("lastModified")
        private String lastModified;
        @Expose
        @SerializedName("dateAdded")
        private String dateAdded;
        @Expose
        @SerializedName("courseId")
        private int courseId;
        @Expose
        @SerializedName("userId")
        private String userId;
        @Expose
        @SerializedName("id")
        private int id;

        public Student getStudent() {
            return Student;
        }

        public void setStudent(Student Student) {
            this.Student = Student;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public int getCourse_id() {
            return course_id;
        }

        public void setCourse_id(int course_id) {
            this.course_id = course_id;
        }

        public String getReviewText() {
            return reviewText;
        }

        public void setReviewText(String reviewText) {
            this.reviewText = reviewText;
        }

        public int getRating() {
            return rating;
        }

        public void setRating(int rating) {
            this.rating = rating;
        }

        public int getCompletionRate() {
            return completionRate;
        }

        public void setCompletionRate(int completionRate) {
            this.completionRate = completionRate;
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

        public int getCourseId() {
            return courseId;
        }

        public void setCourseId(int courseId) {
            this.courseId = courseId;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

    public static class Student {
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
        @SerializedName("password")
        private String password;
        @Expose
        @SerializedName("email")
        private String email;
        @Expose
        @SerializedName("name")
        private String name;
        @Expose
        @SerializedName("id")
        private String id;

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
    }
}

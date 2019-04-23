package com.wlb.framework.learning.data.model.api.wlb.course;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * getCourse Primary
 * List<>
 */
public class CommentRespMdl {

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
        @SerializedName("Responses")
        private List<CommentResponseRespMdl> Responses;
        @Expose
        @SerializedName("Student")
        private Student Student;
        @Expose
        @SerializedName("lessonId")
        private int lessonId;
        @Expose
        @SerializedName("lastModified")
        private String lastModified;
        @Expose
        @SerializedName("dateAdded")
        private String dateAdded;
        @Expose
        @SerializedName("fulltext")
        private String fulltext;
        @Expose
        @SerializedName("title")
        private String title;
        @Expose
        @SerializedName("userId")
        private String userId;
        @Expose
        @SerializedName("id")
        private int id;

        public List<CommentResponseRespMdl> getResponses() {
            return Responses;
        }

        public void setResponses(List<CommentResponseRespMdl> Responses) {
            this.Responses = Responses;
        }

        public Student getStudent() {
            return Student;
        }

        public void setStudent(Student Student) {
            this.Student = Student;
        }

        public int getLessonId() {
            return lessonId;
        }

        public void setLessonId(int lessonId) {
            this.lessonId = lessonId;
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

        public String getFulltext() {
            return fulltext;
        }

        public void setFulltext(String fulltext) {
            this.fulltext = fulltext;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
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
        @SerializedName("avatar")
        private String avatar;
        @Expose
        @SerializedName("roles")
        private String roles;
        @Expose
        @SerializedName("biography")
        private String biography;
        @Expose
        @SerializedName("email")
        private String email;
        @Expose
        @SerializedName("name")
        private String name;
        @Expose
        @SerializedName("id")
        private String id;

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
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

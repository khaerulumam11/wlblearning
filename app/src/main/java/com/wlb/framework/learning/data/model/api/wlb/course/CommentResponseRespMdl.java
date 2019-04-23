package com.wlb.framework.learning.data.model.api.wlb.course;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * getCourse Primary
 * List<>
 */
public class CommentResponseRespMdl {

    @Expose
    @SerializedName("Student")
    private CommentRespMdl.Student Student;
    @Expose
    @SerializedName("discussion_id")
    private int discussion_id;
    @Expose
    @SerializedName("countHelpful")
    private int countHelpful;
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
    @SerializedName("userId")
    private String userId;
    @Expose
    @SerializedName("discussionId")
    private int discussionId;
    @Expose
    @SerializedName("id")
    private int id;

    public CommentRespMdl.Student getStudent() {
        return Student;
    }

    public void setStudent(CommentRespMdl.Student Student) {
        this.Student = Student;
    }

    public int getDiscussion_id() {
        return discussion_id;
    }

    public void setDiscussion_id(int discussion_id) {
        this.discussion_id = discussion_id;
    }

    public int getCountHelpful() {
        return countHelpful;
    }

    public void setCountHelpful(int countHelpful) {
        this.countHelpful = countHelpful;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getDiscussionId() {
        return discussionId;
    }

    public void setDiscussionId(int discussionId) {
        this.discussionId = discussionId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public static class Student {
//        @Expose
//        @SerializedName("avatar")
//        private String avatar;
//        @Expose
//        @SerializedName("roles")
//        private String roles;
//        @Expose
//        @SerializedName("biography")
//        private String biography;
//        @Expose
//        @SerializedName("email")
//        private String email;
//        @Expose
//        @SerializedName("name")
//        private String name;
//        @Expose
//        @SerializedName("id")
//        private String id;
//
//        public String getAvatar() {
//            return avatar;
//        }
//
//        public void setAvatar(String avatar) {
//            this.avatar = avatar;
//        }
//
//        public String getRoles() {
//            return roles;
//        }
//
//        public void setRoles(String roles) {
//            this.roles = roles;
//        }
//
//        public String getBiography() {
//            return biography;
//        }
//
//        public void setBiography(String biography) {
//            this.biography = biography;
//        }
//
//        public String getEmail() {
//            return email;
//        }
//
//        public void setEmail(String email) {
//            this.email = email;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public String getId() {
//            return id;
//        }
//
//        public void setId(String id) {
//            this.id = id;
//        }
//    }
}

package com.wlb.framework.learning.data.model.api.wlb.course;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * getCourse Primary
 * List<>
 */
public class CommentMdl {

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
    @SerializedName("lessonId")
    private int lessonId;
    @Expose
    @SerializedName("discussionId")
    private int discussionId;
    @Expose
    @SerializedName("title")
    private String title;
    @Expose
    @SerializedName("id")
    private int id;
    @Expose
    @SerializedName("itemType")
    private int itemType;

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

    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    public int getDiscussionId() {
        return discussionId;
    }

    public void setDiscussionId(int discussionId) {
        this.discussionId = discussionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

}

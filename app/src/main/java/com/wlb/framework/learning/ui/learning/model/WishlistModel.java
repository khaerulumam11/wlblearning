package com.wlb.framework.learning.ui.learning.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WishlistModel {

    @Expose
    @SerializedName("Course")
    private Course Course;
    @Expose
    @SerializedName("user_id")
    private String user_id;
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

    public Course getCourse() {
        return Course;
    }

    public void setCourse(Course Course) {
        this.Course = Course;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
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

    public static class Course {
        @Expose
        @SerializedName("CreatorUser")
        private CreatorUser CreatorUser;
        @Expose
        @SerializedName("AcademyPromotionId")
        private int AcademyPromotionId;
        @Expose
        @SerializedName("PromoId")
        private int PromoId;
        @Expose
        @SerializedName("lastModified")
        private String lastModified;
        @Expose
        @SerializedName("dateAdded")
        private String dateAdded;
        @Expose
        @SerializedName("status")
        private String status;
        @Expose
        @SerializedName("activeMarketing")
        private int activeMarketing;
        @Expose
        @SerializedName("priceTier")
        private int priceTier;
        @Expose
        @SerializedName("averageRating")
        private int averageRating;
        @Expose
        @SerializedName("countLesson")
        private int countLesson;
        @Expose
        @SerializedName("countEnrollment")
        private int countEnrollment;
        @Expose
        @SerializedName("countSection")
        private int countSection;
        @Expose
        @SerializedName("creator")
        private String creator;
        @Expose
        @SerializedName("language")
        private String language;
        @Expose
        @SerializedName("targetAudience")
        private List<String> targetAudience;
        @Expose
        @SerializedName("requirements")
        private List<String> requirements;
        @Expose
        @SerializedName("goals")
        private List<String> goals;
        @Expose
        @SerializedName("description")
        private String description;
        @Expose
        @SerializedName("subtitle")
        private String subtitle;
        @Expose
        @SerializedName("type")
        private int type;
        @Expose
        @SerializedName("category")
        private int category;
        @Expose
        @SerializedName("slug")
        private String slug;
        @Expose
        @SerializedName("title")
        private String title;
        @Expose
        @SerializedName("id")
        private int id;

        public CreatorUser getCreatorUser() {
            return CreatorUser;
        }

        public void setCreatorUser(CreatorUser CreatorUser) {
            this.CreatorUser = CreatorUser;
        }

        public int getAcademyPromotionId() {
            return AcademyPromotionId;
        }

        public void setAcademyPromotionId(int AcademyPromotionId) {
            this.AcademyPromotionId = AcademyPromotionId;
        }

        public int getPromoId() {
            return PromoId;
        }

        public void setPromoId(int PromoId) {
            this.PromoId = PromoId;
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

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public int getActiveMarketing() {
            return activeMarketing;
        }

        public void setActiveMarketing(int activeMarketing) {
            this.activeMarketing = activeMarketing;
        }

        public int getPriceTier() {
            return priceTier;
        }

        public void setPriceTier(int priceTier) {
            this.priceTier = priceTier;
        }

        public int getAverageRating() {
            return averageRating;
        }

        public void setAverageRating(int averageRating) {
            this.averageRating = averageRating;
        }

        public int getCountLesson() {
            return countLesson;
        }

        public void setCountLesson(int countLesson) {
            this.countLesson = countLesson;
        }

        public int getCountEnrollment() {
            return countEnrollment;
        }

        public void setCountEnrollment(int countEnrollment) {
            this.countEnrollment = countEnrollment;
        }

        public int getCountSection() {
            return countSection;
        }

        public void setCountSection(int countSection) {
            this.countSection = countSection;
        }

        public String getCreator() {
            return creator;
        }

        public void setCreator(String creator) {
            this.creator = creator;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public List<String> getTargetAudience() {
            return targetAudience;
        }

        public void setTargetAudience(List<String> targetAudience) {
            this.targetAudience = targetAudience;
        }

        public List<String> getRequirements() {
            return requirements;
        }

        public void setRequirements(List<String> requirements) {
            this.requirements = requirements;
        }

        public List<String> getGoals() {
            return goals;
        }

        public void setGoals(List<String> goals) {
            this.goals = goals;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getCategory() {
            return category;
        }

        public void setCategory(int category) {
            this.category = category;
        }

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
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
    }

    public static class CreatorUser {
        @Expose
        @SerializedName("status")
        private String status;
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

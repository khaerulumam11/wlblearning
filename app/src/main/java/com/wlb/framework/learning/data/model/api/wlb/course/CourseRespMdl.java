package com.wlb.framework.learning.data.model.api.wlb.course;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * getCourse Primary
 * List<>
 */
public class CourseRespMdl {

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
        @SerializedName("Price")
        private Price Price;
        @Expose
        @SerializedName("CreatorUser")
        private CreatorUser CreatorUser;
        @Expose
        @SerializedName("AcademyCourseCategory")
        private AcademyCourseCategory AcademyCourseCategory;
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
        @SerializedName("video")
        private String video;
        @Expose
        @SerializedName("thumbnail")
        private String thumbnail;
        @Expose
        @SerializedName("level")
        private int level;
        @Expose
        @SerializedName("topic")
        private String topic;
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

        public Price getPrice() {
            return Price;
        }

        public void setPrice(Price Price) {
            this.Price = Price;
        }

        public CreatorUser getCreatorUser() {
            return CreatorUser;
        }

        public void setCreatorUser(CreatorUser CreatorUser) {
            this.CreatorUser = CreatorUser;
        }

        public AcademyCourseCategory getAcademyCourseCategory() {
            return AcademyCourseCategory;
        }

        public void setAcademyCourseCategory(AcademyCourseCategory AcademyCourseCategory) {
            this.AcademyCourseCategory = AcademyCourseCategory;
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

        public String getVideo() {
            return video;
        }

        public void setVideo(String video) {
            this.video = video;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public String getTopic() {
            return topic;
        }

        public void setTopic(String topic) {
            this.topic = topic;
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

    public static class Price {
        @Expose
        @SerializedName("pricing")
        private Pricing pricing;
        @Expose
        @SerializedName("name")
        private String name;
        @Expose
        @SerializedName("id")
        private int id;

        public Pricing getPricing() {
            return pricing;
        }

        public void setPricing(Pricing pricing) {
            this.pricing = pricing;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

    public static class Pricing {
        @Expose
        @SerializedName("USD")
        private String USD;
        @Expose
        @SerializedName("IDR")
        private String IDR;

        public String getUSD() {
            return USD;
        }

        public void setUSD(String USD) {
            this.USD = USD;
        }

        public String getIDR() {
            return IDR;
        }

        public void setIDR(String IDR) {
            this.IDR = IDR;
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

    public static class AcademyCourseCategory {
        @Expose
        @SerializedName("countEnrollCategory")
        private String countEnrollCategory;
        @Expose
        @SerializedName("name")
        private String name;
        @Expose
        @SerializedName("id")
        private int id;

        public String getCountEnrollCategory() {
            return countEnrollCategory;
        }

        public void setCountEnrollCategory(String countEnrollCategory) {
            this.countEnrollCategory = countEnrollCategory;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}

package com.wlb.framework.learning.data.model.api.wlb.course;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * getCourse Primary
 * List<>
 */
public class AboutRespMdl {

    @Expose
    @SerializedName("Price")
    private Price Price;
    @Expose
    @SerializedName("CreatorUser")
    private CreatorUser CreatorUser;
    @Expose
    @SerializedName("Sections")
    private List<Sections> Sections;
    @Expose
    @SerializedName("AcademyCourseCategory")
    private AcademyCourseCategory AcademyCourseCategory;
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
    @SerializedName("video")
    private String video;
    @Expose
    @SerializedName("title")
    private String title;
    @Expose
    @SerializedName("id")
    private int id;

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

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

    public List<Sections> getSections() {
        return Sections;
    }

    public void setSections(List<Sections> Sections) {
        this.Sections = Sections;
    }

    public AcademyCourseCategory getAcademyCourseCategory() {
        return AcademyCourseCategory;
    }

    public void setAcademyCourseCategory(AcademyCourseCategory AcademyCourseCategory) {
        this.AcademyCourseCategory = AcademyCourseCategory;
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

    public static class Sections {
        @Expose
        @SerializedName("Lessons")
        private List<Lessons> Lessons;
        @Expose
        @SerializedName("course_id")
        private int course_id;
        @Expose
        @SerializedName("order")
        private int order;
        @Expose
        @SerializedName("countLesson")
        private int countLesson;
        @Expose
        @SerializedName("courseId")
        private int courseId;
        @Expose
        @SerializedName("title")
        private String title;
        @Expose
        @SerializedName("id")
        private int id;

        public List<Lessons> getLessons() {
            return Lessons;
        }

        public void setLessons(List<Lessons> Lessons) {
            this.Lessons = Lessons;
        }

        public int getCourse_id() {
            return course_id;
        }

        public void setCourse_id(int course_id) {
            this.course_id = course_id;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public int getCountLesson() {
            return countLesson;
        }

        public void setCountLesson(int countLesson) {
            this.countLesson = countLesson;
        }

        public int getCourseId() {
            return courseId;
        }

        public void setCourseId(int courseId) {
            this.courseId = courseId;
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

    public static class Lessons {
        @Expose
        @SerializedName("Questions")
        private List<String> Questions;
        @Expose
        @SerializedName("section_id")
        private int section_id;
        @Expose
        @SerializedName("order")
        private int order;
        @Expose
        @SerializedName("summary")
        private String summary;
        @Expose
        @SerializedName("title")
        private String title;
        @Expose
        @SerializedName("caption")
        private Caption caption;
        @Expose
        @SerializedName("sectionId")
        private int sectionId;
        @Expose
        @SerializedName("courseId")
        private int courseId;
        @Expose
        @SerializedName("id")
        private int id;
        @Expose
        @SerializedName("duration")
        private String duration;

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public List<String> getQuestions() {
            return Questions;
        }

        public void setQuestions(List<String> Questions) {
            this.Questions = Questions;
        }

        public int getSection_id() {
            return section_id;
        }

        public void setSection_id(int section_id) {
            this.section_id = section_id;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Caption getCaption() {
            return caption;
        }

        public void setCaption(Caption caption) {
            this.caption = caption;
        }

        public int getSectionId() {
            return sectionId;
        }

        public void setSectionId(int sectionId) {
            this.sectionId = sectionId;
        }

        public int getCourseId() {
            return courseId;
        }

        public void setCourseId(int courseId) {
            this.courseId = courseId;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

    public static class Caption {
        @Expose
        @SerializedName("id_id")
        private String id_id;
        @Expose
        @SerializedName("en_us")
        private String en_us;

        public String getId_id() {
            return id_id;
        }

        public void setId_id(String id_id) {
            this.id_id = id_id;
        }

        public String getEn_us() {
            return en_us;
        }

        public void setEn_us(String en_us) {
            this.en_us = en_us;
        }
    }

    public static class AcademyCourseCategory {
        @Expose
        @SerializedName("name")
        private String name;
        @Expose
        @SerializedName("id")
        private int id;

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

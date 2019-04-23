package com.wlb.framework.learning.data.model.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(
        tableName = "courses"
)
public class Course {

    @Expose
    @SerializedName("price")
    @ColumnInfo(name = "price")
    public String Price;

    @Expose
    @SerializedName("creator_user_name")
    @ColumnInfo(name = "creator_user_name")
    public String CreatorUserName;

    @Expose
    @SerializedName("creator_user_id")
    @ColumnInfo(name = "creator_user_id")
    public String CreatorUserId;

    @Expose
    @SerializedName("academy_course_category")
    @ColumnInfo(name = "academy_course_category")
    public String AcademyCourseCategory;

    @Expose
    @SerializedName("academy_promotion_id")
    @ColumnInfo(name = "academy_promotion_id")
    public int AcademyPromotionId;

    @Expose
    @SerializedName("promo_id")
    @ColumnInfo(name = "promo_id")
    public int PromoId;

    @Expose
    @SerializedName("last_modified")
    @ColumnInfo(name = "last_modified")
    public String lastModified;

    @Expose
    @SerializedName("date_added")
    @ColumnInfo(name = "date_added")
    public String dateAdded;

    @Expose
    @SerializedName("status")
    @ColumnInfo(name = "status")
    public String status;

    @Expose
    @SerializedName("active_marketing")
    @ColumnInfo(name = "active_marketing")
    public int activeMarketing;

    @Expose
    @SerializedName("price_tier")
    @ColumnInfo(name = "price_tier")
    public int priceTier;

    @Expose
    @SerializedName("average_rating")
    @ColumnInfo(name = "average_rating")
    public int averageRating;

    @Expose
    @SerializedName("count_lesson")
    @ColumnInfo(name = "count_lesson")
    public int countLesson;

    @Expose
    @SerializedName("count_enrollment")
    @ColumnInfo(name = "count_enrollment")
    public int countEnrollment;

    @Expose
    @SerializedName("count_section")
    @ColumnInfo(name = "count_section")
    public int countSection;

    @Expose
    @SerializedName("creator")
    @ColumnInfo(name = "creator")
    public String creator;

    @Expose
    @SerializedName("language")
    @ColumnInfo(name = "language")
    public String language;

//    @Expose
//    @SerializedName("targetAudience")
//    public ArrayList<String> targetAudience;
//
//    @Expose
//    @SerializedName("requirements")
//    public ArrayList<String> requirements;
//
//    @Expose
//    @SerializedName("goals")
//    public ArrayList<String> goals;

    @Expose
    @SerializedName("description")
    @ColumnInfo(name = "description")
    public String description;

    @Expose
    @SerializedName("subtitle")
    @ColumnInfo(name = "subtitle")
    public String subtitle;

    @Expose
    @SerializedName("type")
    @ColumnInfo(name = "type")
    public int type;

    @Expose
    @SerializedName("category")
    @ColumnInfo(name = "category")
    public int category;

    @Expose
    @SerializedName("slug")
    @ColumnInfo(name = "slug")
    public String slug;

    @Expose
    @SerializedName("title")
    @ColumnInfo(name = "title")
    public String title;

    @Expose
    @SerializedName("video")
    @ColumnInfo(name = "video")
    public String video;

    @Expose
    @SerializedName("id")
    @ColumnInfo(name = "id")
    @PrimaryKey
    public Long id;
}
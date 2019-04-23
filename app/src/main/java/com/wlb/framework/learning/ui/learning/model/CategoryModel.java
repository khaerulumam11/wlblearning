package com.wlb.framework.learning.ui.learning.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoryModel {

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
        @SerializedName("AcademyCourseCategories")
        private List<String> AcademyCourseCategories;
        @Expose
        @SerializedName("countCourse")
        private int countCourse;
        @Expose
        @SerializedName("lastModified")
        private String lastModified;
        @Expose
        @SerializedName("dateAdded")
        private String dateAdded;
        @Expose
        @SerializedName("thumbnail")
        private String thumbnail;
        @Expose
        @SerializedName("name")
        private String name;
        @Expose
        @SerializedName("code")
        private String code;
        @Expose
        @SerializedName("id")
        private int id;

        public List<String> getAcademyCourseCategories() {
            return AcademyCourseCategories;
        }

        public void setAcademyCourseCategories(List<String> AcademyCourseCategories) {
            this.AcademyCourseCategories = AcademyCourseCategories;
        }

        public int getCountCourse() {
            return countCourse;
        }

        public void setCountCourse(int countCourse) {
            this.countCourse = countCourse;
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

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}

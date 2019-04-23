package com.wlb.framework.learning.data.model.api.wlb.jw;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public  class VideoDetail {

    @Expose
    @SerializedName("description")
    private String description;
    @Expose
    @SerializedName("playlist")
    private List<PlaylistEntity> playlist;
    @Expose
    @SerializedName("kind")
    private String kind;
    @Expose
    @SerializedName("title")
    private String title;
    @Expose
    @SerializedName("feed_instance_id")
    private String feed_instance_id;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<PlaylistEntity> getPlaylist() {
        return playlist;
    }

    public void setPlaylist(List<PlaylistEntity> playlist) {
        this.playlist = playlist;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFeed_instance_id() {
        return feed_instance_id;
    }

    public void setFeed_instance_id(String feed_instance_id) {
        this.feed_instance_id = feed_instance_id;
    }

    public static class PlaylistEntity {
        @Expose
        @SerializedName("duration")
        private int duration;
        @Expose
        @SerializedName("link")
        private String link;
        @Expose
        @SerializedName("tracks")
        private List<TracksEntity> tracks;
        @Expose
        @SerializedName("sources")
        private List<SourcesEntity> sources;
        @Expose
        @SerializedName("variations")
        private VariationsEntity variations;
        @Expose
        @SerializedName("image")
        private String image;
        @Expose
        @SerializedName("title")
        private String title;
        @Expose
        @SerializedName("pubdate")
        private int pubdate;
        @Expose
        @SerializedName("description")
        private String description;
        @Expose
        @SerializedName("mediaid")
        private String mediaid;

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public List<TracksEntity> getTracks() {
            return tracks;
        }

        public void setTracks(List<TracksEntity> tracks) {
            this.tracks = tracks;
        }

        public List<SourcesEntity> getSources() {
            return sources;
        }

        public void setSources(List<SourcesEntity> sources) {
            this.sources = sources;
        }

        public VariationsEntity getVariations() {
            return variations;
        }

        public void setVariations(VariationsEntity variations) {
            this.variations = variations;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getPubdate() {
            return pubdate;
        }

        public void setPubdate(int pubdate) {
            this.pubdate = pubdate;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getMediaid() {
            return mediaid;
        }

        public void setMediaid(String mediaid) {
            this.mediaid = mediaid;
        }
    }

    public static class TracksEntity {
        @Expose
        @SerializedName("file")
        private String file;
        @Expose
        @SerializedName("kind")
        private String kind;

        public String getFile() {
            return file;
        }

        public void setFile(String file) {
            this.file = file;
        }

        public String getKind() {
            return kind;
        }

        public void setKind(String kind) {
            this.kind = kind;
        }
    }

    public static class SourcesEntity {
        @Expose
        @SerializedName("label")
        private String label;
        @Expose
        @SerializedName("file")
        private String file;
        @Expose
        @SerializedName("type")
        private String type;
        @Expose
        @SerializedName("height")
        private int height;
        @Expose
        @SerializedName("width")
        private int width;

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public String getFile() {
            return file;
        }

        public void setFile(String file) {
            this.file = file;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }
    }

    public static class VariationsEntity {
    }
}

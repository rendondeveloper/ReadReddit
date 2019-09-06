package com.example.rendondev.readreddit.ReadRedditMvp.Data;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class Data_ implements Serializable {

    private final static long serialVersionUID = -8637537288684327501L;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("downs")
    @Expose
    private int downs;
    @SerializedName("ups")
    @Expose
    private int ups;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("num_comments")
    @Expose
    private int numComments;

    /**
     * No args constructor for use in serialization
     */
    public Data_() {
    }

    /**
     * @param numComments
     * @param author
     * @param title
     * @param thumbnail
     * @param downs
     * @param ups
     */
    public Data_(String title, int downs, int ups, String thumbnail, String author, int numComments) {
        super();
        this.title = title;
        this.downs = downs;
        this.ups = ups;
        this.thumbnail = thumbnail;
        this.author = author;
        this.numComments = numComments;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDowns() {
        return downs;
    }

    public void setDowns(int downs) {
        this.downs = downs;
    }

    public int getUps() {
        return ups;
    }

    public void setUps(int ups) {
        this.ups = ups;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNumComments() {
        return numComments;
    }

    public void setNumComments(int numComments) {
        this.numComments = numComments;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("title", title).append("downs", downs).append("ups", ups).append("thumbnail", thumbnail).append("author", author).append("numComments", numComments).toString();
    }

}

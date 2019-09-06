package com.example.rendondev.readreddit.ReadRedditMvp.Data;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.List;

public class Data implements Serializable {

    private final static long serialVersionUID = -8818917443891280325L;
    @SerializedName("modhash")
    @Expose
    private String modhash;
    @SerializedName("dist")
    @Expose
    private int dist;
    @SerializedName("children")
    @Expose
    private List<Child> children = null;

    /**
     * No args constructor for use in serialization
     */
    public Data() {
    }

    /**
     * @param children
     * @param modhash
     * @param dist
     */
    public Data(String modhash, int dist, List<Child> children) {
        super();
        this.modhash = modhash;
        this.dist = dist;
        this.children = children;
    }

    public String getModhash() {
        return modhash;
    }

    public void setModhash(String modhash) {
        this.modhash = modhash;
    }

    public int getDist() {
        return dist;
    }

    public void setDist(int dist) {
        this.dist = dist;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("modhash", modhash).append("dist", dist).append("children", children).toString();
    }

}
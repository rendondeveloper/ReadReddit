package com.example.rendondev.readreddit.ReadRedditMvp.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class Child implements Serializable {

    private final static long serialVersionUID = 3282810973903721467L;
    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("data")
    @Expose
    private Data_ data;

    /**
     * No args constructor for use in serialization
     */
    public Child() {
    }

    /**
     * @param data
     * @param kind
     */
    public Child(String kind, Data_ data) {
        super();
        this.kind = kind;
        this.data = data;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Data_ getData() {
        return data;
    }

    public void setData(Data_ data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("kind", kind).append("data", data).toString();
    }

}







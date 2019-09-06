package com.example.rendondev.readreddit.ReadRedditMvp.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class ReponsePost implements Serializable {

    private final static long serialVersionUID = -860922522303335776L;
    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("data")
    @Expose
    private Data data;

    /**
     * No args constructor for use in serialization
     */
    public ReponsePost() {
    }

    /**
     * @param data
     * @param kind
     */
    public ReponsePost(String kind, Data data) {
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

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("kind", kind).append("data", data).toString();
    }

}

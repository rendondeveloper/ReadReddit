package com.example.rendondev.readreddit.ReadRedditMvp.Model.Retrofic;

import com.example.rendondev.readreddit.ReadRedditMvp.Data.ReponsePost;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiClient {
    @GET("{topic}/.json")
    Call<ReponsePost> GetRedditList(@Path("topic") String topic);
}

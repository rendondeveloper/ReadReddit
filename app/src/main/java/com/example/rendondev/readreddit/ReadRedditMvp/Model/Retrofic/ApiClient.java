package com.example.rendondev.readreddit.ReadRedditMvp.Model.Retrofic;

import com.example.rendondev.readreddit.ReadRedditMvp.Data.ReponsePost;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiClient {
    @GET("funny/.json")
    Call<ReponsePost> GetRedditList();

    @GET("{topic}/.json")
    Call<ReponsePost> GetTopicList(@Path("topic") String topic);
}

package com.example.rendondev.readreddit.ReadRedditMvp.Model.Repository;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.example.rendondev.readreddit.ReadRedditMvp.Data.ReponsePost;
import com.example.rendondev.readreddit.ReadRedditMvp.Model.Interactor.IReadRedditInteractor;
import com.example.rendondev.readreddit.ReadRedditMvp.Model.Retrofic.ApiClient;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ReadRedditRepository implements IReadRedditRepository {

    final private Activity activity;
    final private IReadRedditInteractor interactor;
    final private Retrofit retrofic = new Retrofit.Builder()
            .baseUrl("http://www.reddit.com/r/")
            .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
            .build();
    final private ApiClient apiClient = retrofic.create(ApiClient.class);


    public ReadRedditRepository(final IReadRedditInteractor interactor, final Activity activity) {
        this.activity = activity;
        this.interactor = interactor;
    }

    @Override
    public void GetRedditList() {
        if (!this.internetAvailable()) {
            this.interactor.InternetNotAvailable();
        }

        try {
            final Call<ReponsePost> call = this.apiClient.GetRedditList();
            call.enqueue(new Callback<ReponsePost>() {
                @Override
                public void onResponse(Call<ReponsePost> call, Response<ReponsePost> response) {
                    switch (response.code()) {
                        case 200:
                            final ReponsePost responsePost = response.body();
                            interactor.SetDataList(responsePost.getData().getChildren());
                            break;
                        default:
                            interactor.SetDataList(null);
                            break;
                    }
                }

                @Override
                public void onFailure(Call<ReponsePost> call, Throwable t) {
                    interactor.SetDataList(null);
                }
            });
        } catch (Exception ex) {
            Log.d("", ex.getMessage());
        }
    }


    @Override
    public void GetTopicList(final String topic) {
        if (!this.internetAvailable()) {
            this.interactor.InternetNotAvailable();
        }

        final Call<ReponsePost> call = this.apiClient.GetTopicList(topic);
        call.enqueue(new Callback<ReponsePost>() {
            @Override
            public void onResponse(Call<ReponsePost> call, Response<ReponsePost> response) {
                switch (response.code()) {
                    case 200:
                        final ReponsePost responsePost = response.body();
                        interactor.SetDataList(responsePost.getData().getChildren());
                        break;
                    default:
                        interactor.SetDataList(null);
                        break;
                }
            }

            @Override
            public void onFailure(Call<ReponsePost> call, Throwable t) {
                interactor.SetDataList(null);
            }
        });
    }

    private boolean internetAvailable() {
        final ConnectivityManager connectivityManager = (ConnectivityManager) this.activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        final NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();

        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }
}

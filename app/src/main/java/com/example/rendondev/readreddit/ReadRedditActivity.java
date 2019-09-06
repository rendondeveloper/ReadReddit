package com.example.rendondev.readreddit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.rendondev.readreddit.ReadRedditMvp.Presenter.IReadRedditPresenter;
import com.example.rendondev.readreddit.ReadRedditMvp.Presenter.ReadRedditPresenter;
import com.example.rendondev.readreddit.ReadRedditMvp.View.IReadRedditView;

public class ReadRedditActivity extends AppCompatActivity implements IReadRedditView {

    private IReadRedditPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_reddit);
    }

    @Override
    public void Init() {
        this.presenter = new ReadRedditPresenter(this, this);
    }

    @Override
    public void onClick(View v) {

    }
}

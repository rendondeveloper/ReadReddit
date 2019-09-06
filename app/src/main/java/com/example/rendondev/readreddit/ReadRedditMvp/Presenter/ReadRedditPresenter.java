package com.example.rendondev.readreddit.ReadRedditMvp.Presenter;

import android.app.Activity;

import com.example.rendondev.readreddit.ReadRedditMvp.Model.Interactor.IReadRedditInteractor;
import com.example.rendondev.readreddit.ReadRedditMvp.Model.Interactor.ReadRedditInteractor;
import com.example.rendondev.readreddit.ReadRedditMvp.View.IReadRedditView;

public class ReadRedditPresenter implements IReadRedditPresenter {
    final private IReadRedditInteractor interactor;
    final private Activity activity;
    final private IReadRedditView view;

    public ReadRedditPresenter(final IReadRedditView view, final Activity activity) {
        this.activity = activity;
        this.view = view;
        this.interactor = new ReadRedditInteractor(this, activity);
    }
}

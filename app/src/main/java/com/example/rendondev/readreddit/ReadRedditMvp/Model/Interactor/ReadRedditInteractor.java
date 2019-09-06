package com.example.rendondev.readreddit.ReadRedditMvp.Model.Interactor;

import android.app.Activity;

import com.example.rendondev.readreddit.ReadRedditMvp.Model.Repository.IReadRedditRepository;
import com.example.rendondev.readreddit.ReadRedditMvp.Model.Repository.ReadRedditRepository;
import com.example.rendondev.readreddit.ReadRedditMvp.Presenter.IReadRedditPresenter;

public class ReadRedditInteractor implements IReadRedditInteractor {
    final private IReadRedditPresenter presenter;
    final private Activity activity;
    final private IReadRedditRepository repository;


    public ReadRedditInteractor(final IReadRedditPresenter presenter, final Activity activity) {
        this.presenter = presenter;
        this.activity = activity;
        this.repository = new ReadRedditRepository(this, activity);
    }
}

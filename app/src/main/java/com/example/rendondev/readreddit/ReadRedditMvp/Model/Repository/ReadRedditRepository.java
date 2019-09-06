package com.example.rendondev.readreddit.ReadRedditMvp.Model.Repository;

import android.app.Activity;

import com.example.rendondev.readreddit.ReadRedditMvp.Model.Interactor.IReadRedditInteractor;

public class ReadRedditRepository implements IReadRedditRepository {

    final private Activity activity;
    final private IReadRedditInteractor interactor;

    public ReadRedditRepository(final IReadRedditInteractor interactor, final Activity activity) {
        this.activity = activity;
        this.interactor = interactor;
    }
}

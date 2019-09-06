package com.example.rendondev.readreddit.ReadRedditMvp.Model.Interactor;

import android.app.Activity;

import com.example.rendondev.readreddit.ReadRedditMvp.Data.Child;
import com.example.rendondev.readreddit.ReadRedditMvp.Model.Repository.IReadRedditRepository;
import com.example.rendondev.readreddit.ReadRedditMvp.Model.Repository.ReadRedditRepository;
import com.example.rendondev.readreddit.ReadRedditMvp.Presenter.IReadRedditPresenter;

import java.util.List;

public class ReadRedditInteractor implements IReadRedditInteractor {
    final private IReadRedditPresenter presenter;
    final private Activity activity;
    final private IReadRedditRepository repository;


    public ReadRedditInteractor(final IReadRedditPresenter presenter, final Activity activity) {
        this.presenter = presenter;
        this.activity = activity;
        this.repository = new ReadRedditRepository(this, activity);
    }

    @Override
    public void GetRedditList() {
        this.repository.GetRedditList();
    }

    @Override
    public void SetDataList(final List<Child> postList) {
        this.presenter.SetDataList(postList);
    }

    @Override
    public void InternetNotAvailable() {
        this.presenter.InternetNotAvailable();
    }
}

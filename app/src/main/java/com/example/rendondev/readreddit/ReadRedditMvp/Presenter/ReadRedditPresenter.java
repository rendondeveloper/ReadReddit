package com.example.rendondev.readreddit.ReadRedditMvp.Presenter;

import android.app.Activity;

import com.example.rendondev.readreddit.R;
import com.example.rendondev.readreddit.ReadRedditMvp.Data.Child;
import com.example.rendondev.readreddit.ReadRedditMvp.Model.Interactor.IReadRedditInteractor;
import com.example.rendondev.readreddit.ReadRedditMvp.Model.Interactor.ReadRedditInteractor;
import com.example.rendondev.readreddit.ReadRedditMvp.View.IReadRedditView;

import java.util.List;

public class ReadRedditPresenter implements IReadRedditPresenter {
    final private IReadRedditInteractor interactor;
    final private Activity activity;
    final private IReadRedditView view;

    public ReadRedditPresenter(final IReadRedditView view, final Activity activity) {
        this.activity = activity;
        this.view = view;
        this.interactor = new ReadRedditInteractor(this, activity);
    }

    @Override
    public void GetRedditList() {
        this.interactor.GetRedditList();
    }

    @Override
    public void SetDataList(final List<Child> postList) {
        if (postList == null) {
            this.view.ShowEmptyState();
        } else {
            this.view.SetDataList(postList);
        }
    }

    @Override
    public void InternetNotAvailable() {
        this.view.ShowMessageInfo(this.activity.getString(R.string.message_internet_not_available));
    }
}

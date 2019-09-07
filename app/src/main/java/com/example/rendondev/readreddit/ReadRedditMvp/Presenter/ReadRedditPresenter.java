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
    public void GetRedditList(final String topic) {
        if (topic != null && !topic.isEmpty()) {
            this.view.ManagerState(0);
            this.view.AnimationSearchStarOrStop();
            this.interactor.GetRedditList(topic);
        } else {
            this.view.ShowMessageInfo(this.activity.getString(R.string.message_validation_topics_empty));
        }
    }

    @Override
    public void SetDataList(final List<Child> postList) {
        if (postList == null || postList.isEmpty()) {
            this.view.ManagerState(2);
        } else {
            this.view.ManagerState(1);
            this.view.SetDataList(postList);
        }
        this.view.AnimationSearchStarOrStop();
    }

    @Override
    public void InternetNotAvailable() {
        this.view.ManagerState(3);
        this.view.AnimationSearchStarOrStop();
    }
}

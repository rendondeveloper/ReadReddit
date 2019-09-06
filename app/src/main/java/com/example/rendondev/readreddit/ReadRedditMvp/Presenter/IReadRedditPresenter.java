package com.example.rendondev.readreddit.ReadRedditMvp.Presenter;

import com.example.rendondev.readreddit.ReadRedditMvp.Data.Child;

import java.util.List;

public interface IReadRedditPresenter {
    void GetRedditList();

    void SetDataList(List<Child> postList);

    void InternetNotAvailable();
}

package com.example.rendondev.readreddit.ReadRedditMvp.Model.Interactor;

import com.example.rendondev.readreddit.ReadRedditMvp.Data.Child;

import java.util.List;

public interface IReadRedditInteractor {
    void GetRedditList(final String topic);

    void SetDataList(List<Child> postsDataList);

    void InternetNotAvailable();
}

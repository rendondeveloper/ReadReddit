package com.example.rendondev.readreddit.ReadRedditMvp.View;

import android.view.View;

import com.example.rendondev.readreddit.ReadRedditMvp.Data.Child;

import java.util.List;

public interface IReadRedditView extends View.OnClickListener {
    void Init();

    void SetDataList(List<Child> postList);

    void ShowEmptyState();

    void ShowMessageInfo(String string);
}

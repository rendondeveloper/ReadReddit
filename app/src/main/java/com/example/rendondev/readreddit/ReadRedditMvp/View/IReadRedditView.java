package com.example.rendondev.readreddit.ReadRedditMvp.View;

import android.view.View;

import com.example.rendondev.readreddit.ReadRedditMvp.Data.Child;
import com.example.rendondev.readreddit.ReadRedditMvp.Util.DialogCallBack;

import java.util.List;

public interface IReadRedditView extends View.OnClickListener, DialogCallBack {
    void Init();

    void SetDataList(List<Child> postList);

    void ShowMessageInfo(String string);

    void AnimationSearchStarOrStop();

    void ManagerState(final int state);
}

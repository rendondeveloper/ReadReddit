package com.example.rendondev.readreddit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.example.rendondev.readreddit.ReadRedditMvp.Data.Child;
import com.example.rendondev.readreddit.ReadRedditMvp.Presenter.IReadRedditPresenter;
import com.example.rendondev.readreddit.ReadRedditMvp.Presenter.ReadRedditPresenter;
import com.example.rendondev.readreddit.ReadRedditMvp.View.Adapter.PostAdapter;
import com.example.rendondev.readreddit.ReadRedditMvp.View.IReadRedditView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReadRedditActivity extends AppCompatActivity implements IReadRedditView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.rvCards)
    RecyclerView rvCards;

    private PostAdapter adapter;
    private List<Child> postList;
    private IReadRedditPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_reddit);
        ButterKnife.bind(this);
        this.Init();
    }

    @Override
    public void Init() {
        this.initList();
        this.presenter = new ReadRedditPresenter(this, this);
        this.presenter.GetRedditList();
    }

    @Override
    public void SetDataList(final List<Child> postList) {
        this.postList.clear();
        this.postList.addAll(postList);
        this.adapter.notifyDataSetChanged();
    }

    @Override
    public void ShowEmptyState() {

    }

    @Override
    public void ShowMessageInfo(String string) {

    }

    @Override
    public void onClick(View v) {

    }

    private void initList() {
        this.postList = new ArrayList<>();
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayout.VERTICAL);
        this.adapter = new PostAdapter(this.postList, this);
        this.rvCards.setLayoutManager(linearLayoutManager);
        this.rvCards.setAdapter(this.adapter);
    }
}

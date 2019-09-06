package com.example.rendondev.readreddit.ReadRedditMvp.View;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.rendondev.readreddit.R;
import com.example.rendondev.readreddit.ReadRedditMvp.Data.Child;
import com.example.rendondev.readreddit.ReadRedditMvp.Presenter.IReadRedditPresenter;
import com.example.rendondev.readreddit.ReadRedditMvp.Presenter.ReadRedditPresenter;
import com.example.rendondev.readreddit.ReadRedditMvp.View.Adapter.PostAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReadRedditActivity extends AppCompatActivity implements IReadRedditView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.rvCards)
    RecyclerView rvCards;

    @BindView(R.id.etSearch)
    EditText etSearch;

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
        this.etSearch.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    ObjectAnimator anim = ObjectAnimator.ofFloat(etSearch, "scaleX", 1.3f);
                    anim.setDuration(2000); // duration 3 seconds
                    anim.start();
                } else {
                    ObjectAnimator anim = ObjectAnimator.ofFloat(etSearch, "scaleX", 0.5f);
                    anim.setDuration(2000); // duration 3 seconds
                    anim.start();
                }
            }
        });

        this.etSearch.clearFocus();
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

package com.example.rendondev.readreddit.ReadRedditMvp.View;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.rendondev.readreddit.R;
import com.example.rendondev.readreddit.ReadRedditMvp.Data.Child;
import com.example.rendondev.readreddit.ReadRedditMvp.Presenter.IReadRedditPresenter;
import com.example.rendondev.readreddit.ReadRedditMvp.Presenter.ReadRedditPresenter;
import com.example.rendondev.readreddit.ReadRedditMvp.Util.DialogApp;
import com.example.rendondev.readreddit.ReadRedditMvp.View.Adapter.PostAdapter;
import com.victor.loading.rotate.RotateLoading;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnEditorAction;
import butterknife.OnFocusChange;

public class ReadRedditActivity extends AppCompatActivity implements IReadRedditView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.rvCards)
    RecyclerView rvCards;

    @BindView(R.id.etSearch)
    EditText etSearch;

    @BindView(R.id.llEmpty)
    LinearLayout llEmpty;

    @BindView(R.id.llInternet)
    LinearLayout llInternet;

    RotateLoading rlAnimation;

    private PostAdapter adapter;
    private List<Child> postList;
    private IReadRedditPresenter presenter;
    private DialogApp dialogApp;
    private InputMethodManager managerKeyBoardEvent;

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
        this.dialogApp = new DialogApp(this);
        this.presenter = new ReadRedditPresenter(this, this);
        this.managerKeyBoardEvent = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        this.rlAnimation = findViewById(R.id.rlAnimation);
        this.executeSearch();

    }

    @Override
    public void SetDataList(final List<Child> postList) {
        this.postList.clear();
        this.postList.addAll(postList);
        this.adapter.notifyDataSetChanged();
    }

    @Override
    public void ShowMessageInfo(String message) {
        this.dialogApp.General(getString(R.string.text_default_title), message, this);
    }

    @Override
    public void AnimationSearchStarOrStop() {
        if (this.rlAnimation.isStart()) {
            this.rlAnimation.stop();
        } else {
            this.rlAnimation.start();
        }
    }

    @Override
    public void Execute(int id) {
    }

    @Override
    public void onClick(View v) {
    }

    @Override
    public void ManagerState(final int state) {
        switch (state) {
            case 0: // Search Info
                this.rlAnimation.setVisibility(View.VISIBLE);
                this.llEmpty.setVisibility(View.GONE);
                this.rvCards.setVisibility(View.GONE);
                this.llInternet.setVisibility(View.GONE);
                break;
            case 1: // Show Info
                this.rlAnimation.setVisibility(View.GONE);
                this.llEmpty.setVisibility(View.GONE);
                this.rvCards.setVisibility(View.VISIBLE);
                this.llInternet.setVisibility(View.GONE);
                break;
            case 2: // Show Empty
                this.rlAnimation.setVisibility(View.GONE);
                this.llEmpty.setVisibility(View.VISIBLE);
                this.rvCards.setVisibility(View.GONE);
                this.llInternet.setVisibility(View.GONE);
                break;
            case 3: // Internet Not Available
                this.rlAnimation.setVisibility(View.GONE);
                this.llEmpty.setVisibility(View.GONE);
                this.rvCards.setVisibility(View.GONE);
                this.llInternet.setVisibility(View.VISIBLE);
                break;
        }
    }

    private void initList() {
        this.postList = new ArrayList<>();
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayout.VERTICAL);
        this.adapter = new PostAdapter(this.postList, this);
        this.rvCards.setLayoutManager(linearLayoutManager);
        this.rvCards.setAdapter(this.adapter);
    }

    @OnFocusChange(R.id.etSearch)
    void onFocusChanged(boolean focused) {
        animation(focused);
    }

    @OnEditorAction(R.id.etSearch)
    boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_DONE || event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
            executeSearch();
        }
        return false;
    }

    private void executeSearch() {
        this.presenter.GetRedditList(this.etSearch.getText().toString());
        this.etSearch.clearFocus();
        this.managerKeyBoardEvent.hideSoftInputFromWindow(etSearch.getWindowToken(), 0);
    }

    private void animation(final boolean objectGrowth) {
        final ObjectAnimator animationInput = ObjectAnimator.ofFloat(etSearch, "scaleX", objectGrowth ? 1.2f : 1.0f);
        animationInput.setDuration(1000);
        animationInput.start();
    }
}

package com.example.rendondev.readreddit.ReadRedditMvp.DragAndDrop;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.rendondev.readreddit.R;
import com.example.rendondev.readreddit.ReadRedditMvp.Data.Child;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.rendondev.readreddit.ReadRedditMvp.Model.Repository.ReadRedditRepository.URL_BASE;

public class DragAndDrog extends Activity {

    @BindView(R.id.clData)
    ConstraintLayout clData;

    @BindView(R.id.clReddit)
    ConstraintLayout clReddit;

    @BindView(R.id.clEmail)
    ConstraintLayout clEmail;

    private View viewTouch;
    private Child childItem;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drag_and_drog);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        clData.setOnTouchListener(new MyTouchListener());
        clReddit.setOnDragListener(new MyDragListener());
        clEmail.setOnDragListener(new MyDragListener());

        this.childItem = (Child)getIntent().getExtras().get("Child");

        ((TextView)clData.findViewById(R.id.tvAuthor)).setText(childItem.getData().getAuthor());
        ((TextView)clData.findViewById(R.id.tvTitle)).setText(childItem.getData().getTitle());
        ((TextView)clData.findViewById(R.id.tvCommentsNumber)).setText(String.valueOf(childItem.getData().getNumComments()));
        ((TextView)clData.findViewById(R.id.tvNumberUps)).setText(String.valueOf(childItem.getData().getUps()));

        Glide.with(this)
                .load(childItem.getData().getThumbnail())
                .apply(new RequestOptions().circleCrop())
                .placeholder(R.drawable.ic_place_holder)
                .into(((ImageView)clData.findViewById(R.id.ivPhoto)));

    }


    private void openEmail(){
        final Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:"));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Mira este video");
        emailIntent.putExtra(Intent.EXTRA_TEXT, URL_BASE.substring(0, URL_BASE.length() - 3) +  this.childItem.getData().getUrl());
        startActivity(Intent.createChooser(emailIntent, ""));
    }

    private void openReddit(){
        final Intent chromeIntent = new Intent(Intent.ACTION_VIEW);
        chromeIntent.setData(Uri.parse(URL_BASE.substring(0, URL_BASE.length() - 3) + this.childItem.getData().getUrl()));
        startActivity(chromeIntent);
    }


    private final class MyTouchListener implements View.OnTouchListener {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                viewTouch = view;
                final ClipData data = ClipData.newPlainText("", "");
                final View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(viewTouch);
                viewTouch.startDrag(data, shadowBuilder, view, 0);
                viewTouch.setVisibility(View.INVISIBLE);
                viewTouch.setAlpha(0.5f);
                return true;
            } else {
                return false;
            }
        }
    }

    class MyDragListener implements View.OnDragListener {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                case DragEvent.ACTION_DRAG_ENTERED:
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DROP:

                    if(v.getId() == R.id.clEmail){
                        openEmail();
                    }else if(v.getId() == R.id.clReddit){
                        openReddit();
                    }
                    finish();

                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                    viewTouch.setVisibility(View.VISIBLE);
                    viewTouch.setAlpha(1f);
                default:
                    break;
            }
            return true;
        }
    }
}
package com.example.rendondev.readreddit.ReadRedditMvp.View.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.rendondev.readreddit.R;
import com.example.rendondev.readreddit.ReadRedditMvp.Data.Child;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostHolder> {

    private final List<Child> list;
    private final Activity activity;

    public PostAdapter(final List<Child> list, final Activity activity) {
        this.list = list;
        this.activity = activity;
    }

    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);
        return new PostHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {
        final Child itemPosts = list.get(position);

        holder.tvAuthor.setText(itemPosts.getData().getAuthor());
        holder.tvTitle.setText(itemPosts.getData().getTitle());
        holder.tvCommentsNumber.setText(String.valueOf(itemPosts.getData().getNumComments()));
        holder.tvNumberUps.setText(String.valueOf(itemPosts.getData().getUps()));
        holder.tvNumberDowns.setText(String.valueOf(itemPosts.getData().getDowns()));


        Glide.with(this.activity)
                .load(itemPosts.getData().getThumbnail())
                .apply(new RequestOptions().circleCrop())
                .placeholder(R.drawable.ic_place_holder)
                .into(holder.ivPhoto);
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    public class PostHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.cvItemRaddit)
        CardView cvItemRaddit;
        @BindView(R.id.ivPhoto)
        ImageView ivPhoto;
        @BindView(R.id.tvAuthor)
        TextView tvAuthor;
        @BindView(R.id.tvTitle)
        TextView tvTitle;
        @BindView(R.id.tvCommentsNumber)
        TextView tvCommentsNumber;
        @BindView(R.id.tvNumberUps)
        TextView tvNumberUps;
        @BindView(R.id.tvNumberDowns)
        TextView tvNumberDowns;

        public PostHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

package com.example.rendondev.readreddit.ReadRedditMvp.Model.Repository;

public interface IReadRedditRepository {
    void GetRedditList();

    void GetTopicList(final String topic);
}

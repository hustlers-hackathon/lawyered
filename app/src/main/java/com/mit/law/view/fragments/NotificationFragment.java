package com.mit.law.view.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mit.law.controller.adapter.NotificationAdapter;
import com.mit.law.model.Notification;
import com.mit.lawyered.R;

import java.util.List;

/**
 * Created by Ahmed on 6/10/2017.
 */

public class NotificationFragment extends Fragment {
    List<Notification> notificationList;
    RecyclerView notificationView;

    public static NotificationFragment ins;
    public static NotificationFragment newInstance(List<Notification> notificationList){
        NotificationFragment notificationFragment = new NotificationFragment();
        notificationFragment.setNotificationList(notificationList);

        return notificationFragment;
    }

    public List<Notification> getNotificationList() {
        return notificationList;
    }

    public void setNotificationList(List<Notification> notificationList) {
        this.notificationList = notificationList;
    }



    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup,Bundle savedInstance){
        View v = inflater.inflate(R.layout.fragment_notifications,viewGroup,false);
        notificationView = (RecyclerView) v.findViewById(R.id.rv_notifications);
        notificationView.setLayoutManager(new LinearLayoutManager(getContext()));
        notificationView.setAdapter(new NotificationAdapter(getContext(),notificationList));
        return v;
    }
}

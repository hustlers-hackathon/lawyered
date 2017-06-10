package com.mit.law.view.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mit.lawyered.R;

/**
 * Created by Ahmed on 6/10/2017.
 */

public class NotificationFragment extends Fragment {
    public static NotificationFragment newInstance(){
        NotificationFragment notificationFragment = new NotificationFragment();
        return notificationFragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup,Bundle savedInstance){
        View v = inflater.inflate(R.layout.fragment_notifications,viewGroup,false);

        return v;
    }
}

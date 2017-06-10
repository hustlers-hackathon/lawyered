package com.mit.law.view.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mit.lawyered.R;

/**
 * Created by Ahmed on 6/10/2017.
 */

public class LawsFragment extends Fragment {
    public static LawsFragment newInstance(){
        LawsFragment fragment = new LawsFragment();
        return fragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstance){
        return inflater.inflate(R.layout.fragment_laws,container,false);
    }

}

package com.mit.law.view.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mit.law.controller.adapter.LawsFragmentAdapter;
import com.mit.law.model.Law;
import com.mit.lawyered.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ahmed on 6/10/2017.
 */

public class LawsFragment extends Fragment {
    RecyclerView lawsView ;
    List<Law> lawsList;
    public static LawsFragment newInstance(List<Law> lawList){
        LawsFragment fragment = new LawsFragment();
        fragment.setLawsList(lawList);
        return fragment;

    }

    public void setLawsList(List<Law> lawsList){
        this.lawsList = lawsList;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstance){
        View v =inflater.inflate(R.layout.fragment_laws,container,false);
        lawsView = (RecyclerView) v.findViewById(R.id.rv_laws);
        lawsView.setLayoutManager(new LinearLayoutManager(getContext()));
        lawsView.setAdapter(new LawsFragmentAdapter(getContext(),lawsList));
        return v;

    }


}

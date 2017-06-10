package com.mit.law.view.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mit.law.controller.adapter.NotificationAdapter;
import com.mit.law.controller.adapter.ThirdPartyAdapter;
import com.mit.law.model.Notification;
import com.mit.law.model.ThirdParties;
import com.mit.lawyered.R;

import java.util.List;

/**
 * Created by Ahmed on 6/10/2017.
 */

public class ProfilesFragment extends Fragment {
    List<ThirdParties> thirdParties;
    RecyclerView thirdParty;
    public static ProfilesFragment newInstance(List<ThirdParties> thirdPartiesList){
        ProfilesFragment profilesFragment = ProfilesFragment.newInstance(thirdPartiesList);
        profilesFragment.setThirdParties(thirdPartiesList);
        return profilesFragment;
    }

    public List<ThirdParties> getThirdPartyList() {
        return thirdParties;
    }

    public void setThirdParties(List<ThirdParties> thirdParties) {
        this.thirdParties = thirdParties;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstance){
        View v = inflater.inflate(R.layout.fragment_profiles,viewGroup,false);
        thirdParty = (RecyclerView) v.findViewById(R.id.rv_profiles);
        thirdParty.setLayoutManager(new LinearLayoutManager(getContext()));
        thirdParty.setAdapter(new ThirdPartyAdapter(getContext(),thirdParties));
        return v;
    }
}

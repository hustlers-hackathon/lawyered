package com.mit.law.view.activity;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.mit.law.controller.adapter.LawsFragmentAdapter;
import com.mit.law.taglib.Tag;
import com.mit.law.taglib.TagView;
import com.mit.law.view.fragments.LawsFragment;
import com.mit.lawyered.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ahmed on 6/10/2017.
 */

public class Home extends AppCompatActivity {
    BottomNavigationView bttmView;
    RecyclerView lawsView;
    boolean lawsFragDisplayed = false;
    boolean profFragDisplayed = false;

    TagView tags;

    public static List<String> allTags = new ArrayList<String>(){{
        add("Criminal");
        add("Murder");
        add("Accident");}};



    AutoCompleteTextView searchView;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        bttmView = (BottomNavigationView)findViewById(R.id.navView);
        Toolbar tool = (Toolbar)findViewById(R.id.mainToolbar);
        setSupportActionBar(tool);

        lawsView = (RecyclerView)findViewById(R.id.rv_laws);

        tags = (TagView) findViewById(R.id.tagGroup);
        tags.setOnTagDeleteListener(new TagView.OnTagDeleteListener() {
            @Override
            public void onTagDeleted(TagView view, Tag tag, int position) {
                tags.remove(position);
            }
        });

        //handle user selection on bottom navigation view


        bttmView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment = null;
                        switch (item.getItemId()){
                            case R.id.menu_laws:
                                selectedFragment=LawsFragment.newInstance();
                                break;
                            case R.id.menu_alerts:
                                selectedFragment=null;
                                break;

                            case R.id.menu_profiles:
                                selectedFragment=null;
                                break;
                        }
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame,selectedFragment);
                        transaction.commit();
                        return true;
                    }

                }
        );

        searchView = (AutoCompleteTextView) findViewById(R.id.searchView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,allTags);
        searchView.setAdapter(adapter);

        searchView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //check whether it is an accepted and not selected

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(allTags.contains(s.toString()) && !tags.getTags().contains(s.toString())){
                    Tag tag = new Tag(s.toString());
                    tag.tagTextSize=20;
                    tag.isDeletable=true;
                    tags.addTag(tag);
                    Log.w("Here ","Adding tag");
                    searchView.setText("");
                }
            }
        });

        //manully display the first fragment when activity loads
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame, LawsFragment.newInstance());//have to select the first fragment
        transaction.commit();
    }

    public void getLaws(){
        
    }

}

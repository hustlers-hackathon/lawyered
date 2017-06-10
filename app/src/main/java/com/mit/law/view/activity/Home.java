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
import android.widget.Toast;

import com.mit.law.controller.adapter.LawsFragmentAdapter;
import com.mit.law.controller.firebase.LawsForTagListController;
import com.mit.law.controller.firebase.ReadNotificationController;
import com.mit.law.controller.firebase.ThirdPartyListForTagsController;
import com.mit.law.controller.interfaces.OnResponse;
import com.mit.law.controller.interfaces.OnResponseThirdParties;
import com.mit.law.model.Law;
import com.mit.law.model.Notification;
import com.mit.law.model.ThirdParties;
import com.mit.law.taglib.Tag;
import com.mit.law.taglib.TagView;
import com.mit.law.view.fragments.LawsFragment;
import com.mit.law.view.fragments.NotificationFragment;
import com.mit.law.view.fragments.ProfilesFragment;
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

    AutoCompleteTextView searchView;
    TagView tags;

    public static List<String> allTags = new ArrayList<String>(){{
        add("Criminal");
        add("Murder");
        add("Accident");}};




    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        bttmView = (BottomNavigationView)findViewById(R.id.navView);
        Toolbar tool = (Toolbar)findViewById(R.id.mainToolbar);
        setSupportActionBar(tool);



        tags = (TagView) findViewById(R.id.tagGroup);
        tags.setOnTagDeleteListener(new TagView.OnTagDeleteListener() {
            @Override
            public void onTagDeleted(TagView view, Tag tag, int position) {
                tags.remove(position);
                if(lawsFragDisplayed)getLaws();
                else if(profFragDisplayed)getProfiles();
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
                                getLaws();
                                break;
                            case R.id.menu_alerts:
                                getNotifications();
                                break;

                            case R.id.menu_profiles:
                                getProfiles();
                                break;
                        }


                        return true;
                    }

                }
        );

        searchView = (AutoCompleteTextView) findViewById(R.id.searchView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,allTags);
        searchView.setAdapter(adapter);
        lawsFragDisplayed = true;
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
                    if(lawsFragDisplayed){
                        getLaws();
                        Log.w(" test","get Laws()");
                    }else if(profFragDisplayed){
                        getProfiles();
                    }
                }
            }
        });

        //manully display the first fragment when activity loads
        getLaws();
    }

    public void getLaws(){
        Log.w(" called ","getLaws()");


        LawsForTagListController controller = new LawsForTagListController(new OnResponse() {
            @Override
            public void responded(Object obj) {
                List<Law> lawList = ((List<Law>) obj);
                Log.w(" Size of law List",lawList.size()+"");
                Fragment frag = LawsFragment.newInstance(lawList);


                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame, frag);//have to select the first fragment
                transaction.commit();
                lawsFragDisplayed =true;
                profFragDisplayed =false;

            }
        },getStringTags(tags.getTags()));
    }

    public void getProfiles(){
        ThirdPartyListForTagsController controller = new ThirdPartyListForTagsController(new OnResponseThirdParties() {
            @Override
            public void respondedThird(Object third) {
                List<ThirdParties> thirdPartiesList = ((List<ThirdParties>)third);
                Fragment fragment = ProfilesFragment.newInstance(thirdPartiesList);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame,fragment);
                transaction.commit();

                lawsFragDisplayed =false;
                profFragDisplayed = true;
            }
        },getStringTags(tags.getTags()));
    }

    public void getNotifications(){
        ReadNotificationController notificationController = new ReadNotificationController(new OnResponse() {
            @Override
            public void responded(Object obj) {
                List<Notification> list = ((List<Notification>) obj);
                Fragment frag = NotificationFragment.newInstance(list);

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame,frag);
                transaction.commit();
                Log.w("Notifications",list.size()+" size");
                lawsFragDisplayed = false;
                profFragDisplayed = false;
            }
        });
    }



    private List<String> getStringTags(List<Tag> tags){
        List<String> stringTags = new ArrayList<>();
        for(Tag tag: tags){
            stringTags.add(tag.text);
        }
        //Toast.makeText(getApplicationContext(), stringTags.get(0)+"",Toast.LENGTH_SHORT).show();
        return stringTags;
    }

}

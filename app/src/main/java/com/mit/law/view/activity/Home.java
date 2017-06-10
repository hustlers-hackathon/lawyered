package com.mit.law.view.activity;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.mit.law.view.fragments.LawsFragment;
import com.mit.lawyered.R;

/**
 * Created by Ahmed on 6/10/2017.
 */

public class Home extends AppCompatActivity {
    BottomNavigationView bttmView;
    RecyclerView lawsView;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        bttmView = (BottomNavigationView)findViewById(R.id.navView);
        Toolbar tool = (Toolbar)findViewById(R.id.mainToolbar);
        setSupportActionBar(tool);

        lawsView = (RecyclerView)findViewById(R.id.navView);
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

        //manully display the first fragment when activity loads
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame, LawsFragment.newInstance());//have to select the first fragment
        transaction.commit();
    }

}

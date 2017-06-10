package com.mit.law.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.mit.law.controller.firebase.LawsForTagListController;
import com.mit.law.controller.interfaces.OnResponse;
import com.mit.law.model.Law;
import com.mit.lawyered.R;

import java.util.ArrayList;
import java.util.List;


public class ControlTest extends AppCompatActivity implements OnResponse {

    boolean signSuccess;
    List<Law> lawD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_test);


        List <String>slist=new ArrayList<>();
        slist.add("Criminal");

        LawsForTagListController lawsForTagListController=new LawsForTagListController(this,slist);



    }


    @Override
    public void responded(Object law) {
        lawD=(List<Law>)law;
        Log.d("LAWSIZE2 ",lawD.size()+" ");
    }
}

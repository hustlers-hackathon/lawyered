package com.mit.law.controller.firebase;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mit.law.controller.interfaces.OnResponse;
import com.mit.law.model.ThirdParties;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 6/10/2017.
 */

public class TagsForLawIdController {
    OnResponse response;
    DatabaseReference mDatabaseTags;
    List<String> tagList=new ArrayList<>();
    List <ThirdParties> lawyers;

    public TagsForLawIdController(final OnResponse responder, String lawId){
        this.response=responder;
        mDatabaseTags= FirebaseDatabase.getInstance().getReference().child("laws").child(lawId).child("tags");
        mDatabaseTags.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot dsp:dataSnapshot.getChildren()){
                    tagList.add(String.valueOf(dsp.getValue()));
                }
                responder.responded(tagList);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}

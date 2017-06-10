package com.mit.law.controller.firebase;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mit.law.controller.interfaces.OnResponseThirdParties;
import com.mit.law.model.ThirdParties;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ASUS on 6/10/2017.
 */

public class NotifyThirdPartyListForTagsController {
    DatabaseReference mDatabaseLaw;
    List <ThirdParties> lawyerDescList=new ArrayList<>();
    OnResponseThirdParties response;
    List <String> list;
    SaveNewCaseRequestNotification saveNewCaseRequestNotification;

    public NotifyThirdPartyListForTagsController(OnResponseThirdParties responder,final List <String> list,final String lawId,final String desc){
        mDatabaseLaw= FirebaseDatabase.getInstance().getReference().child("thirdParties");
        this.list=list;
        this.response=responder;

        mDatabaseLaw.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot lawDatasnapshot: dataSnapshot.getChildren()){
                    ThirdParties thirdParties=lawDatasnapshot.getValue(ThirdParties.class);
                    List <String>tags=thirdParties.getTags();
                    if(!Collections.disjoint(tags,list)){
                        lawyerDescList.add(thirdParties);
                    }
                }
                Log.d("Size of LawDescList is ",lawyerDescList.size()+" ");
                response.respondedThird(lawyerDescList);
                saveNewCaseRequestNotification=new SaveNewCaseRequestNotification(lawId,desc,lawyerDescList);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}

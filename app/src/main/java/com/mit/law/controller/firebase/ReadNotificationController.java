package com.mit.law.controller.firebase;

import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mit.law.controller.interfaces.OnResponse;
import com.mit.law.model.Notification;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 6/10/2017.
 */

public class ReadNotificationController {
    FirebaseAuth mAuth;
    DatabaseReference mDatabase;
    OnResponse response;
    List<Notification>nList=new ArrayList<>();
    String id;

    public ReadNotificationController(OnResponse responder){

        this.response=responder;
        mAuth=FirebaseAuth.getInstance();
        mDatabase=FirebaseDatabase.getInstance().getReference().child("notifications");
        id=mAuth.getCurrentUser().getUid();

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot partyDatasnapshot:dataSnapshot.getChildren()){
                    Log.d("NID","Description");
                    Notification notification=partyDatasnapshot.getValue(Notification.class);
                    Log.d("Notification ",notification.getLawShortDesc()+" ....1");

                    if(notification.getStatus()==0){
                        switch (notification.getType()){
                            case "caseRequest":
                                if(notification.getLawyerID().equals(id)){
                                    nList.add(notification);
                                }
                                break;
                            case "caseAccept":
                                if(notification.getUserId().equals(id)){
                                    nList.add(notification);
                                }
                                break;
                            case "location":
                                if(notification.getUserId().equals(id)){
                                    nList.add(notification);
                                }
                                break;
                        }
                    }
                    Log.d("Notification2",nList.size()+" ");
                }
                response.responded(nList);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}

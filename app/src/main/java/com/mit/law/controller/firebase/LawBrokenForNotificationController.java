package com.mit.law.controller.firebase;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.mit.law.controller.interfaces.OnResponse;
import com.mit.law.model.Law;
import com.mit.law.model.LawBroken;
import com.mit.law.model.Notification;

/**
 * Created by ASUS on 6/10/2017.
 */

public class LawBrokenForNotificationController {
    OnResponse responder;
    DatabaseReference mDatabase;
    DatabaseReference mDatabaseStatus;
    Notification notification;
    LawBroken lawbroken;
    Law law;


    public LawBrokenForNotificationController(OnResponse onResponse, Notification notification){
        responder=onResponse;
        this.notification=notification;
        mDatabase= FirebaseDatabase.getInstance().getReference().child("lawBroken");
        mDatabaseStatus= FirebaseDatabase.getInstance().getReference().child("notifications").child(notification.getNid()).child("status");

        mDatabaseStatus.setValue(1);
        Query mQuery =mDatabase.orderByChild("lbid").equalTo(notification.getLbid());
        mQuery.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                lawbroken=dataSnapshot.getValue(LawBroken.class);
                responder.responded(lawbroken);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


}

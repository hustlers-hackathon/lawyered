package com.mit.law.controller.firebase;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;
import com.mit.law.model.Notification;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mit.law.controller.interfaces.OnResponse;
import com.mit.law.model.Law;
import com.mit.law.model.LawBroken;

/**
 * Created by ASUS on 6/10/2017.
 */

public class LawBrokenForNotificationController {
    OnResponse responder;
    DatabaseReference mDatabase;
    DatabaseReference mDatabaseStatus;
    Notification notification;
    LawBroken lawBroken;
    Law law;

    public LawBrokenForNotificationController(OnResponse onResponse,Notification notification){
        this.responder=onResponse;
        this.notification=notification;
        mDatabase= FirebaseDatabase.getInstance().getReference().child("lawBroken");
        mDatabaseStatus=FirebaseDatabase.getInstance().getReference().child("notifications").child(notification.getNid()).child("status");
        mDatabaseStatus.setValue(1);

        Query mQuery=mDatabase.orderByChild("lbId").equalTo(notification.getLbid());

        mQuery.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                lawBroken=dataSnapshot.getValue(LawBroken.class);
                responder.responded(lawBroken);
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

package com.mit.law.controller.firebase;

import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.mit.law.controller.interfaces.OnResponseLaw;
import com.mit.law.model.Law;
import com.mit.law.model.LawBroken;
import com.mit.law.model.Notification;

/**
 * Created by ASUS on 6/10/2017.
 */

public class FindLawBrokenController {
    OnResponseLaw responder;
    DatabaseReference mDatabase;
    DatabaseReference mDatabaseStatus;
    Notification n;
    Law law;

    public FindLawBrokenController(OnResponseLaw onResponseLaw, final LawBroken lawBroken,Notification nn){
        this.responder=onResponseLaw;
        this.n=nn;
        mDatabase= FirebaseDatabase.getInstance().getReference().child("laws");
        mDatabaseStatus= FirebaseDatabase.getInstance().getReference().child("notifications");

        Query mQuery=mDatabase.orderByChild("lawId").equalTo(lawBroken.getLawId());

        mQuery.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                law=dataSnapshot.getValue(Law.class);
                mDatabaseStatus.child(n.getNid()).child("lawShortDesc").setValue(law.getShortDesc());
                responder.respondedLaw(law);
                Log.d("LAW1",law.getShortDesc());
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

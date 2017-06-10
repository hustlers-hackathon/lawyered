package com.mit.law.controller.firebase;

import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mit.law.model.Notification;

/**
 * Created by ASUS on 6/10/2017.
 */

public class AcceptRequestController {
    DatabaseReference mAccept;
    FirebaseAuth mAuth;
    Notification notification;

    public AcceptRequestController(Notification notifi){
        notification=new Notification();
        mAccept= FirebaseDatabase.getInstance().getReference().child("notifications");
        mAuth=FirebaseAuth.getInstance();
        notification.setLbid(notifi.getLbid());

        String email=mAuth.getCurrentUser().getEmail();
        int index=email.indexOf("@");
        email=email.substring(0,index);

        notification.setUserId(notifi.getUserId());
        notification.setStatus(0);
        notification.setType("caseAccept");
        notification.setLawBrokenDesc(notifi.getLawBrokenDesc());
        notification.setLawShortDesc(notifi.getLawShortDesc());
        notification.setDesc(email+" has accepted your case");
        notification.setLbid(notifi.getLbid());
        notification.setLawyerID(notifi.getLawyerID());
        String key=mAccept.push().getKey();
        notification.setNid(key);
        Log.d("Check accept",notification.getNid());
        mAccept.child(key).setValue(notification);

    }
}

package com.mit.law.controller.firebase;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mit.law.model.LawBroken;
import com.mit.law.model.Notification;
import com.mit.law.model.ThirdParties;

import java.util.List;

/**
 * Created by ASUS on 6/10/2017.
 */

public class SaveNewCaseRequestNotification {
    DatabaseReference mDatabaseLawBroken;
    DatabaseReference mDatabaseNotification;
    FirebaseAuth mAuth;

    public SaveNewCaseRequestNotification(String lawId, String description, List<ThirdParties> thirdPartiesList){
        mAuth=FirebaseAuth.getInstance();
        String currentUID=mAuth.getCurrentUser().getUid();
        mDatabaseLawBroken= FirebaseDatabase.getInstance().getReference().child("lawBroken");
        mDatabaseNotification=FirebaseDatabase.getInstance().getReference().child("notifications");
        LawBroken lawBroken=new LawBroken();
        lawBroken.setLawId(lawId);
        lawBroken.setDescription(description);
        lawBroken.setUserId(currentUID);
        String key=mDatabaseLawBroken.push().getKey();
        lawBroken.setLbId(key);
        mDatabaseLawBroken.child(key).setValue(lawBroken);

        for(ThirdParties party:thirdPartiesList){
            Notification notification=new Notification();
            notification.setLbid(key);
            notification.setUserId(currentUID);
            notification.setStatus(0);
            notification.setType("caseRequest");
            notification.setLawBrokenDesc(description);
            notification.setLawShortDesc(" ");
            String email=mAuth.getCurrentUser().getEmail();
            int index=email.indexOf("@");
            email=email.substring(0,index);
            notification.setDesc(email+" has brought up a case");
            String keyN=mDatabaseNotification.push().getKey();
            notification.setNid(keyN);
            notification.setLawyerID(party.getTpid());
            mDatabaseNotification.child(keyN).setValue(notification);
        }

    }
}

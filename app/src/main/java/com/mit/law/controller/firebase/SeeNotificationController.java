package com.mit.law.controller.firebase;

import android.util.Log;

import com.mit.law.controller.interfaces.OnResponse;
import com.mit.law.controller.interfaces.OnResponseLaw;
import com.mit.law.model.Law;
import com.mit.law.model.LawBroken;
import com.mit.law.model.Notification;

/**
 * Created by ASUS on 6/10/2017.
 */

public class SeeNotificationController implements OnResponse,OnResponseLaw {

    LawBrokenForNotificationController lawBrokenForNotificationController;
    FindLawBrokenController findLawBrokenController;


    LawBroken lawb;
    Law law;
    //DatabaseReference mNotify;
    Notification n;


    public SeeNotificationController(Notification notifi){
        this.n=notifi;
        Log.d("Look NID :",n.getNid());
        lawBrokenForNotificationController=new LawBrokenForNotificationController(this,n);
        //mNotify= FirebaseDatabase.getInstance().getReference().child("notifications");
    }

    @Override
    public void responded(Object lawBroken) {

        lawb=(LawBroken)lawBroken;
        findLawBrokenController=new FindLawBrokenController(this,lawb,n);
    /*  notification=new Notification();
        notification.setLbid(lawb.getLbid());
        notification.setUserId(lawb.getUserId());
        notification.setStatus(0);
        notification.setType("caseAccept");
        notification.setLawBrokenDesc(lawb.getDescription());*/
        Log.d("Description: ",lawb.getDescription());
    }

    @Override
    public void respondedLaw(Object acceptN) {
        law=(Law)acceptN;
        Log.d("Law is ",law.getShortDesc());
       /* notification.setLawShortDesc(law.getShortDesc());
        String keyN=mNotify.push().getKey();
        notification.setNid(keyN);
        mNotify.child(keyN).setValue(notification);*/
    }

    public Notification getAccept(){
        Log.d("Law is ",n.getLawShortDesc());
        return n;
    }

}

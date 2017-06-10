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

    Notification n;
    LawBroken lawb;
    Law law;

    public SeeNotificationController(Notification notifi){
        this.n=notifi;
        lawBrokenForNotificationController=new LawBrokenForNotificationController(this,n);
    }

    @Override
    public void responded(Object lawBroken) {
        lawb=(LawBroken)lawBroken;
      findLawBrokenController=new FindLawBrokenController(this,lawb,n);
        Log.d("Description :",lawb.getDescription());
    }

    @Override
    public void respondedLaw(Object acceptN) {
        law=(Law)acceptN;
        Log.d("Law is :",law.getShortDesc());
    }

    public Notification getAccept(){
        Log.d("3 Law is :",n.getLawShortDesc());
        return n;
    }
}

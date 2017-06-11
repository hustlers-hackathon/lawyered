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

public class ThirdPartyListForTagsController {
    DatabaseReference mDatabaseLaw;
    List <ThirdParties> lawyerDescList;
    public OnResponseThirdParties response;
    List<String>list;

    public ThirdPartyListForTagsController(OnResponseThirdParties responder, final List<String>list){
        mDatabaseLaw= FirebaseDatabase.getInstance().getReference().child("thirdParties");
        this.list=list;
        this.response=responder;
        mDatabaseLaw.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                lawyerDescList=new ArrayList<>();
                if(list.size()==0){
                    for (DataSnapshot lawyerDatasnapshot:dataSnapshot.getChildren()){
                        ThirdParties party=lawyerDatasnapshot.getValue(ThirdParties.class);

                        lawyerDescList.add(party);

                    }


                }
                for (DataSnapshot lawyerDatasnapshot:dataSnapshot.getChildren()){
                    ThirdParties party=lawyerDatasnapshot.getValue(ThirdParties.class);
                    List<String>tags=party.getTags();
                    if(!Collections.disjoint(tags,list)){

                        lawyerDescList.add(party);
                    }

                }
                Log.d("LAWYERSIZE ",lawyerDescList.size()+" ");
                response.respondedThird(lawyerDescList);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public List<ThirdParties> getAllLawyerDescForTags(){
        return lawyerDescList;
    }

}

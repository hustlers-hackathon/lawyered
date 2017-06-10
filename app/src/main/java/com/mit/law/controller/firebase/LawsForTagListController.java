package com.mit.law.controller.firebase;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mit.law.controller.interfaces.OnResponse;
import com.mit.law.model.Law;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ASUS on 6/10/2017.
 */

public class LawsForTagListController {
    DatabaseReference mDatabaseLaw;
    List <Law> lawDescList=new ArrayList<>();
    public OnResponse response;
    List<String>list;

    public LawsForTagListController(OnResponse responder,final List<String>list){
        mDatabaseLaw= FirebaseDatabase.getInstance().getReference().child("laws");
        this.list=list;
        this.response=responder;
        mDatabaseLaw.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(list.size()==0){
                    for (DataSnapshot lawDatasnapshot:dataSnapshot.getChildren()){
                        Law law=lawDatasnapshot.getValue(Law.class);

                        lawDescList.add(law);

                    }


                }
                for (DataSnapshot lawDatasnapshot:dataSnapshot.getChildren()){
                    Law law=lawDatasnapshot.getValue(Law.class);
                    List<String>tags=law.getTags();
                    if(!Collections.disjoint(tags,list)){
                        law.setFullDesc(null);
                        lawDescList.add(law);
                    }

                }
                Log.d("LAWSIZE ",lawDescList.size()+" ");
                response.responded(lawDescList);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public List<Law> getAllLawDescForTags(){
        return lawDescList;
    }

}

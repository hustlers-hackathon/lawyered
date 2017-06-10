package com.mit.law.controller.firebase;

/**
 * Created by ASUS on 6/10/2017.
 */


        import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mit.law.controller.interfaces.OnResponse;
import com.mit.law.model.ThirdParties;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 5/12/2017.
 */

public  class ThirdPartyController {

    List<ThirdParties> parties = new ArrayList<>();
    private static final String TAG = "ControlTest";
    ThirdParties thirdParty;

    public static final String EXTRA_POST_KEY = "post_key";
    public DatabaseReference mDatabaseThirdParty;
    public OnResponse response;


    
    //Get lawyer by id
    public ThirdPartyController(OnResponse responder, final String lawyerId){
        response = responder;
        mDatabaseThirdParty= FirebaseDatabase.getInstance().getReference().child("thirdParties");
        mDatabaseThirdParty.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot partyDataSnapshot : dataSnapshot.getChildren()) {

                    if (partyDataSnapshot.getKey().equals(lawyerId)){
                        thirdParty = partyDataSnapshot.getValue(ThirdParties.class);
                    }

                }

                response.responded(thirdParty);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });
    }


    public DatabaseReference getmDatabaseThirdParty(){
        return mDatabaseThirdParty;
    }

    public List<ThirdParties> getAllThirdParties(){




        return parties;


    }


}

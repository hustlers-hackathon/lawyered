package com.mit.law.controller.firebase;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mit.law.controller.interfaces.OnResponse;
import com.mit.law.model.ThirdParties;
import com.mit.law.model.User;

/**
 * Created by ASUS on 6/10/2017.
 */

public class SignUpController {
    FirebaseAuth mAuth;
    DatabaseReference mDatabase;
    DatabaseReference mDatabaseThirdParty;
    boolean isSuccessful;
    OnResponse responder;

    public SignUpController(OnResponse onResponse, final User user) {
        this.responder=onResponse;
        mAuth=FirebaseAuth.getInstance();
        mDatabase= FirebaseDatabase.getInstance().getReference().child("users");
        String email=user.getEmail();
        String password=user.getPassword();
        Log.d("SignUp :","Check 1");
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Log.d("SignUp :","task success 1");
                    String userID=mAuth.getCurrentUser().getUid();
                    mDatabase.child(userID).setValue(user);
                    isSuccessful=true;
                    responder.responded(isSuccessful);

                }else{
                    isSuccessful=false;
                }
            }
        });

    }

    public SignUpController(OnResponse onResponse, final User user, final ThirdParties thirdParties) {
        this.responder=onResponse;
        mAuth=FirebaseAuth.getInstance();
        mDatabase= FirebaseDatabase.getInstance().getReference().child("users");
        mDatabaseThirdParty= FirebaseDatabase.getInstance().getReference().child("thirdParties");
        String email=user.getEmail();
        String password=user.getPassword();
        Log.d("SignUp :","Check 1");
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Log.d("SignUp :","task success 1");
                    String userID=mAuth.getCurrentUser().getUid();
                    mDatabase.child(userID).setValue(user);
                    thirdParties.setTpid(userID);
                    thirdParties.setRateCount(0);
                    thirdParties.setReviewAvg(0);

                    mDatabaseThirdParty.child(userID).setValue(thirdParties);
                    isSuccessful=true;
                    responder.responded(isSuccessful);

                }else{
                    isSuccessful=false;
                }
            }
        });

    }
}

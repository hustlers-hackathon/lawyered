package com.mit.law.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mit.lawyered.R;

public class SignIn extends AppCompatActivity {

    TextView userEmail;
    TextView passWord;
    Button signIn;
    FirebaseAuth auth;
    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        mDatabase= FirebaseDatabase.getInstance().getReference().child("users");

        userEmail = (EditText) findViewById(R.id.email);
        passWord = (EditText)findViewById(R.id.password);

        signIn = (Button) findViewById(R.id.btnSignIn);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLogIn();
            }
        });
        auth = FirebaseAuth.getInstance();
    }

    private void checkUser(){
        String email = userEmail.getText().toString().trim();//get from field
        final String pass = passWord.getText().toString();

        //check the whether fields are empty
        if(TextUtils.isEmpty(email)){
            Toast.makeText(getApplicationContext(),"Please enter the email address",Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(pass)){
            Toast.makeText(getApplicationContext(),"Enter Password",Toast.LENGTH_SHORT).show();
            return;
        }

        //try signing in
        auth.signInWithEmailAndPassword(email,pass)
                .addOnCompleteListener(SignIn.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(!task.isSuccessful()){
                            //there was an error
                            Toast.makeText(getApplicationContext(),"Check the inputs ",Toast.LENGTH_SHORT).show();

                        }else{

                            Intent intent = new Intent(SignIn.this,Home.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                });
    }
    private void checkLogIn() {
        String email=userEmail.getText().toString().trim();
        String password=passWord.getText().toString().trim();

        if(!TextUtils.isEmpty(email)&& !TextUtils.isEmpty(password)){
            auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        checkUserExist();
                    }else{
                        Toast.makeText(SignIn.this, "Please Sign Up", Toast.LENGTH_SHORT).show();
                        //Intent mainIntent=new Intent(SignIn.this,TabActivitySignUp.class);
                        //mainIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        //startActivity(mainIntent);
                    }
                }
            });
        }
    }

    private void checkUserExist() {
        final String user_id=auth.getCurrentUser().getUid();

        mDatabase.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.hasChild(user_id)){
                    Intent mainIntent=new Intent(SignIn.this,Home.class);
                    Toast.makeText(SignIn.this, "Signing in", Toast.LENGTH_SHORT).show();
                    mainIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(mainIntent);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                //Toast.makeText(SignIn.this, "Error LogIn", Toast.LENGTH_SHORT).show();

            }
        });
    }

}

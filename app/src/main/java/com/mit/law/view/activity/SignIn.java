package com.mit.law.view.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import com.mit.lawyered.R;

import org.w3c.dom.Text;

public class SignIn extends AppCompatActivity {

    TextView userEmail;
    TextView passWord;
    Button signIn;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        userEmail = (EditText) findViewById(R.id.email);
        passWord = (EditText)findViewById(R.id.password);

        signIn = (Button) findViewById(R.id.btnSignIn);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkUser();
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
}

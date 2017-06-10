package com.mit.law.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
    }

    private void checkUser(){

    }
}

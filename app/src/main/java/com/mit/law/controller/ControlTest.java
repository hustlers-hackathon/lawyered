package com.mit.law.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mit.law.controller.firebase.SignUpController;
import com.mit.law.controller.interfaces.OnResponse;
import com.mit.law.model.User;
import com.mit.lawyered.R;


public class ControlTest extends AppCompatActivity implements OnResponse {

    boolean signSuccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_test);

        User user=new User();
        user.setEmail("nadun@gmail.com");
        user.setName("Nadun jayakody");
        user.setPassword("naduns");
        user.setBalance("Rs.500.00");
        user.setType("Public");

        SignUpController signUpController=new SignUpController(this,user);

    }

    @Override
    public void responded(Object obj) {
        signSuccess=(boolean)obj;
    }
}

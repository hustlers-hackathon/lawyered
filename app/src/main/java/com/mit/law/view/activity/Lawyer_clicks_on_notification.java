package com.mit.law.view.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mit.lawyered.R;

public class Lawyer_clicks_on_notification extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lawyer_clicks_on_notification);

        Button ignore = (Button) findViewById(R.id.btnIgnore);
        Button see = (Button) findViewById(R.id.btnSeeProfile);

        ignore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        see.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code to direct to the lawyer's profile
            }
        });

    }
}

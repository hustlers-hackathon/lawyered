package com.mit.law.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mit.lawyered.R;

public class Clicks_on_law_dialog extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clicks_on_law_dialog);

        EditText msg = (EditText) findViewById(R.id.etMessage);
        Button send = (Button) findViewById(R.id.btnSend);
        Button dismiss = (Button) findViewById(R.id.btnDismiss);

        String message = msg.getText().toString();

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code to send the message
            }
        });

        dismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

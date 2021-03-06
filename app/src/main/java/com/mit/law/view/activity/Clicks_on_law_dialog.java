package com.mit.law.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.mit.law.controller.firebase.RequestController;
import com.mit.lawyered.R;

public class Clicks_on_law_dialog extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clicks_on_law_dialog);


        //Check this out whether it is working or not, or else remove it
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.x = -20;
        params.height = 400;
        params.width = 550;
        params.y = -10;

        this.getWindow().setAttributes(params);

        final EditText msg = (EditText) findViewById(R.id.etMessage);
        Button send = (Button) findViewById(R.id.btnSend);
        Button dismiss = (Button) findViewById(R.id.btnDismiss);



        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code to send the message
                String message = msg.getText().toString();
                String lawID = (String)getIntent().getExtras().get("LAW_ID");
                RequestController requestController = new RequestController(lawID,message);
                finish();
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

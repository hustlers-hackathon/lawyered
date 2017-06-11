package com.mit.law.view.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mit.law.controller.firebase.AcceptRequestController;
import com.mit.law.model.Notification;
import com.mit.lawyered.R;

import org.w3c.dom.Text;

public class Lawyer_clicks_on_notification extends Activity {
    Notification noti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lawyer_clicks_on_notification);
        noti = (Notification)getIntent().getExtras().get("noti");

        TextView title = (TextView)findViewById(R.id.tvTitle);
        TextView showMesg = (TextView)findViewById(R.id.tvShowMsg);
        TextView brokenLaw = (TextView)findViewById(R.id.tvBrokenLaw);

        title.setText(noti.getDesc());
        brokenLaw.setText(noti.getLawShortDesc());
        showMesg.setText(noti.getLawBrokenDesc());
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
                AcceptRequestController controller = new AcceptRequestController(noti);
                finish();
            }
        });

    }
}

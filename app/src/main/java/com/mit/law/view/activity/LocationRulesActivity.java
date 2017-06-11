package com.mit.law.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import com.mit.law.model.LocationRules;
import com.mit.law.model.Notification;
import com.mit.lawyered.R;

/**
 * Created by Ahmed on 6/11/2017.
 */

public class LocationRulesActivity extends AppCompatActivity {
    TextView title;
    TextView shortDescription;
    WebView fullDescription;

    LocationRules locationRules;
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.law_in_full);

        Notification noti = (Notification) getIntent().getExtras().get("noti");
        locationRules = new LocationRules();
        locationRules.setShortDesc(noti.getLawBrokenDesc());
        locationRules.setFullDesc(noti.getDesc());


        title = (TextView)findViewById(R.id.tvTitleLaw);
        shortDescription = (TextView)findViewById(R.id.tvLawInShort);
        fullDescription = (WebView)findViewById(R.id.wvFullLaw);

        title.setText(noti.getLawShortDesc());
        shortDescription.setText(locationRules.getShortDesc());


        Button btnMar = (Button)findViewById(R.id.btnMarkBroken);
        btnMar.setVisibility(View.GONE);
        Button btnMore = (Button)findViewById(R.id.btnViewMore);
        btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fullDescription.loadData(locationRules.getFullDesc(),"text/html",null);
                Log.w(" Description",locationRules.getFullDesc());
            }
        });
    }
}

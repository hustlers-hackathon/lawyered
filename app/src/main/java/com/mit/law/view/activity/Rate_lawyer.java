package com.mit.law.view.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

import com.mit.lawyered.R;

public class Rate_lawyer extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rate_lawyer);


        RatingBar rb = (RatingBar) findViewById(R.id.ratebar);
        rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                String rate = String.valueOf(rating);
                //rest of the code
            }
        });

        Button ok = (Button)findViewById(R.id.btnOk);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //do something with value
            }
        });

        Button cancel = (Button)findViewById(R.id.btnCancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}

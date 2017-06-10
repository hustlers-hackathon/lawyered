package com.mit.law.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mit.law.model.ThirdParties;
import com.mit.law.taglib.Tag;
import com.mit.law.taglib.TagView;
import com.mit.lawyered.R;

/**
 * Created by Ahmed on 6/10/2017.
 */

public class ProfileDetailsActivity extends AppCompatActivity{
    ThirdParties thirdParty;
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.profile_in_full);
        thirdParty = (ThirdParties)getIntent().getExtras().get("Third_Party");

        TextView name = (TextView)findViewById(R.id.tvName);
        TextView rate = (TextView)findViewById(R.id.tvRate);
        TagView tagGroup = (TagView)findViewById(R.id.ProfileTagsGroup);
        TextView shortDesc = (TextView)findViewById(R.id.tvLawyerShortDescr);

        Button btnContact = (Button)findViewById(R.id.btnContact);
        Button btnRate = (Button)findViewById(R.id.btnRate);


        final TextView mobile = (TextView)findViewById(R.id.tvMobile);
        final TextView office = (TextView)findViewById(R.id.tvOffice);

        name.setText(thirdParty.getName());
        rate.setText(thirdParty.getReviewAvg()+"");
        shortDesc.setText(thirdParty.getDesc());
        for(String str:thirdParty.getTags()){
            Tag tag = new Tag(str);
            tag.isDeletable=false;
            tag.tagTextSize = 20;
            tagGroup.addTag(tag);
        }

        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mobile.setText(thirdParty.getMobile());
                office.setText(thirdParty.getOffice());
            }
        });

        btnRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Rate_lawyer.class);
                startActivity(intent);
            }
        });

    }
}

package com.mit.law.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import com.mit.law.model.Law;
import com.mit.lawyered.R;

/**
 * Created by Ahmed on 6/10/2017.
 */

public class LawDetailsActivity extends AppCompatActivity {
    Law law;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.law_in_full);

        law =(Law)getIntent().getExtras().get("LAW");
        TextView lawTitle = (TextView) findViewById(R.id.tvTitleLaw);
        TextView shortDesc = (TextView) findViewById(R.id.tvLawInShort);

        Button btnMark = (Button) findViewById(R.id.btnMarkBroken);
        Button btnViewMore = (Button) findViewById(R.id.btnViewMore);

        TextView quote = (TextView)findViewById(R.id.tvQuote);

        final WebView fullLaw = (WebView) findViewById(R.id.wvFullLaw);

        lawTitle.setText(law.getTitle());
        shortDesc.setText(law.getShortDesc());
        quote.setText(law.getQuote());
        btnMark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Clicks_on_law_dialog.class);
                Bundle extras = new Bundle();
                extras.putString("LAW_ID",law.getLawId());
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
        btnViewMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fullLaw.loadData(law.getFullDesc(),"text/html",null);
            }
        });

    }

    private void init(){

    }
}

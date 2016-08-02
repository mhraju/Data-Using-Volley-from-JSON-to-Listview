package com.mhraju.webservice.web_service_list_view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PoetDestailsActivity extends AppCompatActivity {

    TextView PoetId, PoetName, PoetBio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poet_destails);
        Bundle bundle = getIntent().getExtras();

        PoetName = (TextView) findViewById(R.id.name);
        PoetBio = (TextView) findViewById(R.id.bio);

        PoetName.setText(bundle.getString("name"));
        PoetBio.setText(bundle.getString("bio"));
    }
}
package com.example.reshal.testapp1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RandomActivity extends AppCompatActivity {
    Button click;
    public TextView data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);
        click = findViewById(R.id.button);
        data = findViewById(R.id.textView);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeAPICall();
            }
        });
    }

    protected void makeAPICall(){
        String mathURL = "random/";
        retrieveAPIData retrieveAPIData = new retrieveAPIData(mathURL, data);
        retrieveAPIData.execute();
//        return null;
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }
}

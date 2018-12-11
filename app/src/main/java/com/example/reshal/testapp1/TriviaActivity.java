package com.example.reshal.testapp1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TriviaActivity extends AppCompatActivity {

    Button click;
    public static TextView data;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trivia);

        click = findViewById(R.id.button);
        data = findViewById(R.id.textView);
        editText = findViewById(R.id.inputText);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeAPICall();
            }
        });
    }

    protected Void makeAPICall(){
        String text = editText.getText().toString();
        String mathURL = "";
        try {
            int inp = Integer.parseInt(text);

            retrieveAPIData retrieveAPIData = new retrieveAPIData(text+mathURL, data);
            retrieveAPIData.execute();
        } catch (NumberFormatException e){
            e.printStackTrace();
            //Toast!
            Context context = getApplicationContext();
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, "Enter a number", duration);
            toast.show();
        }
        return null;
    }
}

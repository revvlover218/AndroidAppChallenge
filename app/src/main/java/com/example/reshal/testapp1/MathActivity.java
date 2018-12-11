package com.example.reshal.testapp1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class MathActivity extends AppCompatActivity {

    /*The reason why it is initiated here is because, this is where the objects can be accessed from
     * external classes.
     * It also has to be set to public static.*/
    Button click;
    public static TextView data;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);
//        Intent intent = getIntent();

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

   //TODO:
    // - Retrieve input from the inputField.
    // - convert to string text.
    // - append to math string.
    protected Void makeAPICall(){
        String text = editText.getText().toString();
        String mathURL = "/math";
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
    /*TODO:
    * - Get the name of the current class.
    * - Convert to text format.
    * - Pass two parameters to the APIData class.*/
}
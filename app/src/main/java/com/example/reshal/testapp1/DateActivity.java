package com.example.reshal.testapp1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DateActivity extends AppCompatActivity {

    Button click;
    public static TextView data;
    EditText editTextMonth;
    EditText editTextDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);
        click = findViewById(R.id.button);
        data = findViewById(R.id.textView);
        editTextMonth = findViewById(R.id.inputTextMonth);
        editTextDay = findViewById(R.id.inputTextDay);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeAPICall();
            }
        });
    }

    protected Void makeAPICall(){
        String month = editTextMonth.getText().toString();
        String day = editTextDay.getText().toString();
        String URL = "/date";
        String dateURL = month + "/" + day + "/" + URL;
        try {

            int monthInt = Integer.parseInt(month);
            int dayInt = Integer.parseInt(day);

            if(monthInt >= 1 && monthInt <=12 && dayInt >= 1 && dayInt <= 31){
                retrieveAPIData retrieveAPIData = new retrieveAPIData(dateURL, data);
                retrieveAPIData.execute();
            } else{
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, "Invalid date entered", duration);
                toast.show();
            }


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

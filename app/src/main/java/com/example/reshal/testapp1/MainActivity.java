package com.example.reshal.testapp1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /*List View of items on the Main screen.*/
    String[] listItemText = new String[]{"Math", "Trivia", "Date", "Random"};
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItemText);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Math
                if(i == 0) {
                    Intent intent = new Intent(view.getContext(), MathActivity.class);
                    startActivityForResult(intent, 0);
                }
                //Trivia
                if(i == 1) {
                    Intent intent = new Intent(view.getContext(), TriviaActivity.class);
                    startActivityForResult(intent, 0);
                }
                //Date
                if(i == 2) {
                    Intent intent = new Intent(view.getContext(), DateActivity.class);
                    startActivityForResult(intent, 0);
                }
                //Random
                if(i == 3) {
                    Intent intent = new Intent(view.getContext(), RandomActivity.class);
                    startActivityForResult(intent, 0);
                }
            }
        });
    }
}

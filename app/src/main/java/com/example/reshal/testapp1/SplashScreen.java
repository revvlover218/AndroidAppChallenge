package com.example.reshal.testapp1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    /*An intent is an operation ABOUT TO take place.
    * The intention to start at the splash screen and finish
    * at the Main screen is done by using the Intent object and
    * setting the AndroidManifest.xml file to point to the splash
    * screen.*/
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*This only creates the action. It is NOT executed yet!*/
        Intent intent = new Intent(this, MainActivity.class);
        /*This executes the action.*/
        startActivity(intent);
        finish();
    }
}

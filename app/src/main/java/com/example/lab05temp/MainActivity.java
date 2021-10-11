package com.example.lab05temp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MainActivity extends AppCompatActivity {
    String TAG = "com.example.lab05temp.sharedprefs";
    LifecycleData currentRun, lifeTime;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    TextView currentRunTV, lifeTimeTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //load SharedPrefences
        sharedPreferences = getSharedPreferences(TAG, MODE_PRIVATE);
        //instantiate editor
        editor = sharedPreferences.edit();
        //instantiate classes
        currentRun = new LifecycleData();
        currentRun.duration="Current Run";
        //get lifecycleData from sharedPrefrences as String
        String lifecycleDataAsString = sharedPreferences.getString("lifetime", "");
        //Instantiate new Lifetime Data if empty string
            //else convert JSON to LifetimeData object
        if (lifecycleDataAsString.equals("")){
            lifeTime = new LifecycleData();
            lifeTime.duration = "Lifetime Data";
        } else {
            lifeTime = LifecycleData.parseJSON(lifecycleDataAsString);
        }
        //instantiate TextViews
        currentRunTV = findViewById(R.id.curernt);
        lifeTimeTV = findViewById(R.id.lifetime);
        //display data on TextViews
        currentRunTV.setText(currentRun.toString());
        lifeTimeTV.setText(lifeTime.toString());
    }
}
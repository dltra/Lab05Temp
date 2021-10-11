package com.example.lab05temp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class LifecycleData {
    int onCreate   = 0;
    int onStart    = 0;
    int onResume   = 0;
    int onPause    = 0;
    int onStop     = 0;
    int onRestart  = 0;
    int onDestroy  = 0;
    String duration;
    public String toString(){
        return duration +"/n"+
                "onCreate /t"+onCreate+"/n" +
                "onStart /t"+onStart+"/n" +
                "onResume /t"+onResume+"/n" +
                "onPause /t"+onPause+"/n" +
                "onStop /t"+onStop+"/n" +
                "onRestart /t"+onRestart+"/n" +
                "onDestroy /t"+onDestroy+"/n";
    }
    //convert this instance to a String
    String toJSON(){
        Gson gson = new Gson();
        return gson.toJson(this, LifecycleData.class);
    }
    //from JSON String to class using GSON
    static LifecycleData parseJSON(String fromSharedPreferences){
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(fromSharedPreferences, LifecycleData.class);
    }
}

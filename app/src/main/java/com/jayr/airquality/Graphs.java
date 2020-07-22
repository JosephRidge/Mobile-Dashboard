package com.jayr.airquality;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.FirebaseDatabase;
/// OUR GOAL HERE IS TO PLOT GRAPHS USING THE DATA ATTAINED>>>
public class Graphs extends MainActivity{
    private static final String LOG_TAG;
    static {
        LOG_TAG = MainActivity.class.getSimpleName();
    }

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    TextView hum;
    TextView ammonia;
    TextView carbon_dio;
    TextView carbon_mon;
    TextView heat_indexC;
    TextView temp_celcious;
    TextView vibrations;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graphs);
    }
}

//public void colorschemes(){
//    font title =#346B91
//        navbar =#E0F7FF
//            body=#F5F5F5
//            font body =#97D0F6
//}
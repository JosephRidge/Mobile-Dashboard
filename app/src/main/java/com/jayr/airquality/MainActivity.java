package com.jayr.airquality;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import static java.lang.Float.parseFloat;

public class MainActivity extends AppCompatActivity {
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
        setContentView(R.layout.activity_main);

//    private static final String TAG = "MainActivity";

        FirebaseDatabase database = FirebaseDatabase.getInstance();//we must start by attaining aninstance if firebase db

        Query sound_vibrations = database.getReference().child("Sound/SoundLevel");
        DatabaseReference humidity = database.getReference().child("DHT11/Humidity");

            sound_vibrations.keepSynced(true);
            targetTextViews();
            //payload functions
            humidityValue();
            coValue();
            co2Value();
            temperatureValue();
            ammoniaValue();
            soundLevelValue();

        }

        public void declarations(){
// we must always start with instansiating firebase db
//            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference Temp_IndexF = database.getReference().child("DHT11/HeatIndex_F");
            DatabaseReference Temp_IndexC = database.getReference().child("DHT11/HeatIndexC");

//            DatabaseReference sound_vibrations = database.getReference().child("Sound/SoundLevel");
//            return humidity;
        }
        public void targetTextViews(){

//        this.heat_indexC = (TextView) findViewById(R.id.heatindex);
//        this.ammonia = (TextView) findViewById(R.id.ammmonia);
//            this.hum = (TextView) findViewById(R.id.humidity_id);
//        this.temp_celcious = (TextView) findViewById(R.id.temp_levels);
//        this.carbon_mon = (TextView) findViewById(R.id.carbon2);
//        this.carbon_dio = (TextView) findViewById(R.id.carbon4);
//        this.vibrations = (TextView) findViewById(R.id.sound);
        }

        public void humidityValue(){
            DatabaseReference humidity = database.getReference().child("DHT11/Humidity");
            humidity.addValueEventListener(new ValueEventListener() {
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                        String moistureLevels = (String) ds.getValue(String.class);
                        TextView textView = MainActivity.this.hum;
                        StringBuilder sb = new StringBuilder();
                        sb.append(String.valueOf(moistureLevels));
                        StringBuilder append = sb.append("%");
                        textView.setText(sb.toString());
                        Log.d(MainActivity.LOG_TAG, "\n******************************************************________________________***********************************______________________*************************************************** /n ");
                        String access$000 = MainActivity.LOG_TAG;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Humidity levels : ");
                        sb2.append(moistureLevels);
                        sb2.append("\n");
                        Log.d(access$000, sb2.toString());
                    }
                }

                public void onCancelled(DatabaseError databaseError) {
                }
            });
        }

        public void co2Value(){
            DatabaseReference carbon_dioxide = database.getReference().child("MQ4/CarbonDioxide");
            carbon_dioxide.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    for (DataSnapshot ds: dataSnapshot.getChildren()){
                    String co2 = (String) ds.getValue(String.class);
                    TextView textView = MainActivity.this.hum; //*******************************URGENT
                    StringBuilder sb = new StringBuilder();
                    sb.append(String.valueOf(co2));
                    StringBuilder append = sb.append("%");
                    textView.setText(sb.toString());
                    Log.d(MainActivity.LOG_TAG, "\n******************************************************************************************************* /n ");
                    String access$000 = MainActivity.LOG_TAG;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Carbon(iv)oxide levels : ");
                    sb2.append(co2);
                    sb2.append("\n");
                    Log.d(access$000, sb2.toString());
                }
            }


                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Log.d(LOG_TAG,"Bro!! Nikubaya kimeumana hehehehe.....");

                }
            });

        }

        public void coValue(){
        DatabaseReference carbonmonoxide = database.getReference().child("MQ7/CarbonMonoxide");
        carbonmonoxide.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds: dataSnapshot.getChildren()){
                    String co = (String) ds.getValue(String.class);
                    TextView textView = MainActivity.this.hum; //*******************************URGENT
                    StringBuilder sb = new StringBuilder();
                    sb.append(String.valueOf(co));
                    StringBuilder append = sb.append("%");
                    textView.setText(sb.toString());
                    Log.d(MainActivity.LOG_TAG, "\n******************************************************************************************************* /n ");
                    String access$000 = MainActivity.LOG_TAG;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Carbon(ii)oxide levels : ");
                    sb2.append(co);
                    sb2.append("\n");
                    Log.d(access$000, sb2.toString());
                }
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d(LOG_TAG,"Bro!! Nikubaya kimeumana hehehehe.....");

            }
        });

    }

        public void temperatureValue(){
        DatabaseReference Temp = database.getReference().child("DHT11/Temperature_Celsius");
        Temp.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds: dataSnapshot.getChildren()){
                    String temp = (String) ds.getValue(String.class);
                    TextView textView = MainActivity.this.hum; //*******************************URGENT
                    StringBuilder sb = new StringBuilder();
                    sb.append(String.valueOf(temp));
                    StringBuilder append = sb.append("%");
                    textView.setText(sb.toString());
                    Log.d(MainActivity.LOG_TAG, "\n******************************************************************************************************* /n ");
                    String access$000 = MainActivity.LOG_TAG;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Temperature levels (in Celcious) : ");
                    sb2.append(temp);
                    sb2.append("\n");
                    Log.d(access$000, sb2.toString());
                }
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d(LOG_TAG,"Bro!! Nikubaya kimeumana hehehehe.....");

            }
        });

    }

        public void ammoniaValue(){
        DatabaseReference Ammonia = database.getReference().child("MQ135/Ammonia");
        Ammonia.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds: dataSnapshot.getChildren()){
                    String ammonia = (String) ds.getValue(String.class);
                    TextView textView = MainActivity.this.hum; //*******************************URGENT
                    StringBuilder sb = new StringBuilder();
                    sb.append(String.valueOf(ammonia));
                    StringBuilder append = sb.append("%");
                    textView.setText(sb.toString());
                    Log.d(MainActivity.LOG_TAG, "\n************************************************************ /n ");
                    String access$000 = MainActivity.LOG_TAG;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Ammonia levels : ");
                    sb2.append(ammonia);
                    Log.d(access$000, sb2.toString());
                }
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d(LOG_TAG,"Bro!! Nikubaya kimeumana hehehehe.....");

            }
        });

    }

        public void soundLevelValue(){
        DatabaseReference disturbanceLevel = database.getReference().child("Sound/SoundLevel");
        disturbanceLevel.addValueEventListener(new ValueEventListener() {
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    String noiseLevels = (String) ds.getValue(String.class);
                    TextView textView = MainActivity.this.hum;//******************************review!!
                    StringBuilder sb = new StringBuilder();
                    sb.append(String.valueOf(noiseLevels));
                    StringBuilder append = sb.append("%");
                    textView.setText(sb.toString());
                    Log.d(MainActivity.LOG_TAG, "\n******************************************************________________________***********************************______________________*************************************************** /n ");
                    String access$000 = MainActivity.LOG_TAG;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Noise levels : ");
                    sb2.append(noiseLevels);
                    sb2.append("\n");
                    Log.d(access$000, sb2.toString());
                }
            }

            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
    }

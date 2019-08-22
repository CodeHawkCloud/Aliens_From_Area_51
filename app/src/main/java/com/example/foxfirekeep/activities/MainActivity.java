package com.example.foxfirekeep.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.foxfirekeep.activities.R;

public class MainActivity extends AppCompatActivity {

    //splash time interval
    private int splash_time = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent mmIntent = new Intent(MainActivity.this,Main_Menu.class);
                startActivity(mmIntent);
                finish();
            }
        },splash_time);
    }
}

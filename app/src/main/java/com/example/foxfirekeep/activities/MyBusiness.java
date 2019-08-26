package com.example.foxfirekeep.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.foxfirekeep.activities.R;

public class MyBusiness extends AppCompatActivity {
     ImageView home1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_business);

        home1 = (ImageView)findViewById(R.id.buton_home);

        home1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it1 = new Intent(MyBusiness.this,Main_Menu.class);
                startActivity(it1);
            }
        });
    }
}

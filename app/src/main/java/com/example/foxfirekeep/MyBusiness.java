package com.example.foxfirekeep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MyBusiness extends AppCompatActivity {
    private ImageView home1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_business);

        home1 = (ImageView)findViewById(R.id.button_home);

        home1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it1 = new Intent(MyBusiness.this,Main_Menu.class);
                startActivity(it1);
            }
        });
    }
}

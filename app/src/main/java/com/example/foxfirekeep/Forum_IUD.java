package com.example.foxfirekeep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Forum_IUD extends AppCompatActivity {
    private ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum__iud);

        back = (ImageView)findViewById(R.id.imageView10);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it1 = new Intent(Forum_IUD.this,ForumCrudMenu.class);
                startActivity(it1);
            }
        });
    }
}

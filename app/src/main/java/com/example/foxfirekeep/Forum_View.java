package com.example.foxfirekeep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Forum_View extends AppCompatActivity {
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum__view);

        back = (ImageView)findViewById(R.id.imageView4);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it1 = new Intent(Forum_View.this,ForumCrudMenu.class);
                startActivity(it1);
            }
        });
    }

    }


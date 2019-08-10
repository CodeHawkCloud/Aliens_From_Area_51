package com.example.foxfirekeep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class StocksUpdate extends AppCompatActivity {
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_stocks);

        back = (ImageView)findViewById(R.id.btnBack);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it1 = new Intent(StocksUpdate.this,inventoryCrudMenu.class);
                startActivity(it1);
            }
        });
    }
}

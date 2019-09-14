package com.example.foxfirekeep.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.foxfirekeep.activities.R;
import com.example.foxfirekeep.adapters.forumsAdapter;
import com.example.foxfirekeep.database.DBHandler;
import com.example.foxfirekeep.models.Forums;

import java.util.List;

public class Forum_View extends AppCompatActivity {
    ImageView back;
    DBHandler dbHandler;
    List<Forums> forumsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum__view);

        back = (ImageView)findViewById(R.id.button_back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it1 = new Intent(Forum_View.this,ForumCrudMenu.class);
                startActivity(it1);
            }
        });

        ListView listView = (ListView)findViewById(R.id.forum_list_view);

        dbHandler = new DBHandler(this);

        forumsList = dbHandler.readForum();

        forumsAdapter forumsAdapter = new forumsAdapter(this, R.layout.adapter_forum_view,forumsList);
        listView.setAdapter(forumsAdapter);
    }

    }


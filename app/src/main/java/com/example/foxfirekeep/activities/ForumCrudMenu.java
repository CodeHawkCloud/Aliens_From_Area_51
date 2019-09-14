package com.example.foxfirekeep.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.foxfirekeep.activities.R;
import com.example.foxfirekeep.database.DBHandler;
import com.example.foxfirekeep.models.Forums;

import java.util.List;

public class ForumCrudMenu extends AppCompatActivity {

    private ImageView home1;
    private ImageView in;
    private ImageView up;
    private ImageView del;
    private ImageView vi;

    DBHandler dbHandler;
    List<Forums> forumsList;
    Toast t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum_crud_menu);

        home1 = (ImageView)findViewById(R.id.button_home);
        in = (ImageView)findViewById(R.id.button_crud_insert);
        up = (ImageView)findViewById(R.id.button_crud_update);
        del = (ImageView)findViewById(R.id.button_crud_delete);
        vi = (ImageView)findViewById(R.id.button_crud_view);

        home1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it1 = new Intent(ForumCrudMenu.this,Main_Menu.class);
                startActivity(it1);
            }
        });

        in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it2 = new Intent(ForumCrudMenu.this,Forum_IUD.class);
                startActivity(it2);
            }
        });

        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it3 = new Intent(ForumCrudMenu.this,Forum_IUD.class);
                startActivity(it3);
            }
        });

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it4 = new Intent(ForumCrudMenu.this,Forum_IUD.class);
                startActivity(it4);
            }
        });

        dbHandler = new DBHandler(this);

        vi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                forumsList = dbHandler.readForum();

                if(forumsList.size()!=0){
                    Intent it5 = new Intent(ForumCrudMenu.this, Forum_View.class);
                    startActivity(it5);
                }else{
                    t = Toast.makeText(getApplicationContext(),"No one has used the forum yet!", Toast.LENGTH_LONG);
                    t.show();
                }
            }
        });

    }
}

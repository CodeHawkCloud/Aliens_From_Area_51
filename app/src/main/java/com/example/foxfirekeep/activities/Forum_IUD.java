package com.example.foxfirekeep.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.foxfirekeep.activities.R;
import com.example.foxfirekeep.database.DBHandler;
import com.example.foxfirekeep.models.Forums;

import java.util.List;

public class Forum_IUD extends AppCompatActivity {
    private ImageView back;
    EditText eForumsInsertId, eForumsInsertUsername,eForumsInsertRole,eForumsInserComment; //variables for the edit text
    ImageButton forumsInsertButton,forumsDeleteButton,forumsEditButton;
    List<Forums> forumsList;
    Toast t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum__iud);

        back = (ImageView)findViewById(R.id.button_back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it1 = new Intent(Forum_IUD.this,ForumCrudMenu.class);
                startActivity(it1);
            }
        });


        //assigning values to the variables using the ids of the EditText
        eForumsInsertId = findViewById(R.id.edit_forum_iud_id);
        eForumsInsertUsername= findViewById(R.id.edit_forum_iud_username);
        eForumsInsertRole = findViewById(R.id.edit_forum_iud_role);
        eForumsInserComment = findViewById(R.id.edit_forum_iud_comment);

        //assigning submit button
        forumsInsertButton = (ImageButton)findViewById(R.id.btnFrmSub);
        forumsEditButton = (ImageButton)findViewById(R.id.btnFrmEdit);

    }


    public void onClickInsert(View view){

        String onForumsInsertid= eForumsInsertId.getText().toString();
        String onForumsInsertUsername =  eForumsInsertUsername.getText().toString();
        String onForumsInsertRole = eForumsInsertRole.getText().toString();
        String onForumsInserComment = eForumsInserComment.getText().toString();

        //DBHandler object created
        DBHandler dbhandler = new DBHandler(this);

        //Toast creation
        Toast t;

        if(!onForumsInsertid.isEmpty() && !onForumsInserComment.isEmpty() && !onForumsInsertUsername.isEmpty() && !onForumsInserComment.isEmpty()) {
            //check if the insertion was successful
            int insertId = Integer.parseInt(onForumsInsertid);

            if (dbhandler.addForum(insertId, onForumsInsertUsername, onForumsInsertRole, onForumsInserComment)) {
                //Toast message if insertion is successful
                t = Toast.makeText(getApplicationContext(), "Record has been added to FoxFire!", Toast.LENGTH_LONG);
                t.show();
            } else {
                //Toast message if insertion fails
                t = Toast.makeText(getApplicationContext(), "Record has not been added to FoxFire!", Toast.LENGTH_LONG);
                t.show();
            }
        }else{
            t = Toast.makeText(getApplicationContext(), "Please fill in all the fields!", Toast.LENGTH_LONG);
            t.show();
        }

    }


    public void onClickDelete(View view){

        String onForumsDeleteId = eForumsInsertId.getText().toString();

        //DBHandler object created
        DBHandler dbhandler = new DBHandler(this);

        //Toast creation
        Toast t;

        if(!onForumsDeleteId.isEmpty()) {
            //check if the insertion was successful
            int deleteID = Integer.parseInt(onForumsDeleteId);

            if (dbhandler.deleteForms(deleteID)) {
                //Toast message if deletion is successful
                t = Toast.makeText(getApplicationContext(), "Record deleted from FoxFire!", Toast.LENGTH_LONG);
                t.show();
            } else {
                //Toast message if insertion fails
                t = Toast.makeText(getApplicationContext(), "Record deletion failed!", Toast.LENGTH_LONG);
                t.show();
            }
        }else{
            t = Toast.makeText(getApplicationContext(), "Please fill in the id to be deleted!", Toast.LENGTH_LONG);
            t.show();
        }
    }



    public void onClickUpdete(View view){

        String onForumsUpdateId= eForumsInsertId.getText().toString();
        String onForumsUpdatetUsername =  eForumsInsertUsername.getText().toString();
        String onForumsUpdateRole = eForumsInsertRole.getText().toString();
        String onForumsUpdateComment = eForumsInserComment.getText().toString();
        //DBHandler object created
        DBHandler dbhandler = new DBHandler(this);

        //Toast creation
        Toast t;

        if(!onForumsUpdateId.isEmpty() && !onForumsUpdatetUsername.isEmpty() && !onForumsUpdateRole.isEmpty() && !onForumsUpdateComment.isEmpty()) {
            //check if the insertion was successful
            int onForumId = Integer.parseInt(onForumsUpdateId);

            if (dbhandler.updateForum(onForumId, onForumsUpdatetUsername, onForumsUpdateRole, onForumsUpdateComment)) {
                //Toast message if insertion is successful
                t = Toast.makeText(getApplicationContext(), "Forum has been updated successfully!", Toast.LENGTH_LONG);
                t.show();
            } else {
                //Toast message if insertion fails
                t = Toast.makeText(getApplicationContext(), "Forum failed to be updated!", Toast.LENGTH_LONG);
                t.show();
            }
        }else{
            t = Toast.makeText(getApplicationContext(), "Please fill in all the fields!", Toast.LENGTH_LONG);
            t.show();
        }
    }

    public void onClickView(View view){

        DBHandler dbHandler = new DBHandler(this);

        forumsList = dbHandler.readForum();

        if(forumsList.size()!=0){
            Intent it1 = new Intent(Forum_IUD.this, Forum_View.class);
            startActivity(it1);
        }else{
            t = Toast.makeText(getApplicationContext(),"No one has used the forum yet!", Toast.LENGTH_LONG);
            t.show();
        }


    }



}

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

public class Forum_IUD extends AppCompatActivity {
    private ImageView back;
    EditText eForumsInsertId, eForumsInsertUsername,eForumsInsertRole,eForumsInserComment; //variables for the edit text
    ImageButton forumsInsertButton,forumsDeletebutton;
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




        /*---------------insert crud operation 1st part [START]---------------*/

        //assigning values to the variables using the ids of the EditText
        eForumsInsertId = findViewById(R.id.edit_forum_iud_id);
        eForumsInsertUsername= findViewById(R.id.edit_forum_iud_username);
        eForumsInsertRole = findViewById(R.id.edit_forum_iud_role);
        eForumsInserComment = findViewById(R.id.edit_forum_iud_comment);

        //assigning submit button
        forumsInsertButton = (ImageButton)findViewById(R.id.btnFrmSub);
        forumsDeletebutton= (ImageButton)findViewById(R.id.btnFrmdel);




        /*---------------insert crud operation 1st part [END]-----------------*/

    }



    /*---------------insert crud operation 2nd part [START]---------------*/

    public void onClickInsert(View view){


        int onForumsInsertid= Integer.parseInt(eForumsInsertId.getText().toString());
        String onForumsInsertUsername =  eForumsInsertUsername.getText().toString();
        String onForumsInsertRole = eForumsInsertRole.getText().toString();
        String onForumsInserComment = eForumsInserComment.getText().toString();

        //DBHandler object created
        DBHandler dbhandler = new DBHandler(this);

        //Toast creation
        Toast t;

        //check if the insertion was successful
        if(dbhandler.addForum(onForumsInsertid,onForumsInsertUsername,onForumsInsertRole,onForumsInserComment)){
            //Toast message if insertion is successful
            t = Toast.makeText(getApplicationContext(),"Recode has been added to FoxFire!", Toast.LENGTH_LONG);
            t.show();
        }
        else{
            //Toast message if insertion fails
            t = Toast.makeText(getApplicationContext(),"Recode has not been added to FoxFire!", Toast.LENGTH_LONG);
            t.show();
        }

    }

    /*---------------insert crud operation 2nd part [END]-----------------*/



    public void onClickDelete(View view){

        int onForumsInsertid = Integer.parseInt(eForumsInsertId.getText().toString());

        //DBHandler object created
        DBHandler dbhandler = new DBHandler(this);

        //Toast creation
        Toast t;

        //check if the insertion was successful
        if(dbhandler.deleteForms(onForumsInsertid)){
            //Toast message if deletion is successful
            t = Toast.makeText(getApplicationContext(),"Delete from FoxFire!", Toast.LENGTH_LONG);
            t.show();
        }
        else{
            //Toast message if insertion fails
            t = Toast.makeText(getApplicationContext(),"Deletion failed!", Toast.LENGTH_LONG);
            t.show();
        }
    }



    public void onClickUpdete(View view){

        int onForumsInsertid= Integer.parseInt(eForumsInsertId.getText().toString());
        String onForumsInsertUsername =  eForumsInsertUsername.getText().toString();
        String onForumsInsertRole = eForumsInsertRole.getText().toString();
        String onForumsInserComment = eForumsInsertRole.getText().toString();
        //DBHandler object created
        DBHandler dbhandler = new DBHandler(this);

        //Toast creation
        Toast t;

        //check if the insertion was successful
        if(dbhandler.updateForum(onForumsInsertid,onForumsInsertUsername,onForumsInsertRole,onForumsInserComment)){
            //Toast message if insertion is successful
            t = Toast.makeText(getApplicationContext(),"Forum has been updated successfully!", Toast.LENGTH_LONG);
            t.show();
        }
        else{
            //Toast message if insertion fails
            t = Toast.makeText(getApplicationContext(),"Forum failed to be updated!", Toast.LENGTH_LONG);
            t.show();
        }
    }



}

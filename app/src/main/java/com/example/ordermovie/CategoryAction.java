// Chenqian Cao

package com.example.ordermovie;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CategoryAction extends AppCompatActivity {
    private DatabaseReference myRef;
    private FirebaseDatabase database;

    private Button action1Button;
    private Button action2Button;
    private Button action3Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_action);

        action1Button = (Button) findViewById(R.id.action1Button);
        action2Button = (Button) findViewById(R.id.action2Button);
        action3Button = (Button) findViewById(R.id.action3Button);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("movies");

        action1Button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                myRef.child("KICK").setValue("Action: Kick");
                Toast.makeText(getApplicationContext(),"Successfully added!", Toast.LENGTH_LONG).show();
            }
        });

        action2Button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                myRef.child("DRIVE").setValue("Action: Drive");
                Toast.makeText(getApplicationContext(),"Successfully added!", Toast.LENGTH_LONG).show();
            }
        });

        action3Button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                myRef.child("AVENGERS").setValue("Action: Avengers");
                Toast.makeText(getApplicationContext(),"Successfully added!", Toast.LENGTH_LONG).show();
            }
        });
    }
}

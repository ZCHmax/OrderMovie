// Zhenhao Sun

package com.example.ordermovie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CategoryHorror extends AppCompatActivity {
    private DatabaseReference myRef;
    private FirebaseDatabase database;

    private String horror = "";
    private Button horror1Button;
    private Button horror2Button;
    private Button horror3Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_horror);

        horror1Button = (Button) findViewById(R.id.horror1Button);
        horror2Button = (Button) findViewById(R.id.horror2Button);
        horror3Button = (Button) findViewById(R.id.horror3Button);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("movies");

        horror1Button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                myRef.child("CITYOFGOLD").setValue("Horror: City of Gold");
                Toast.makeText(getApplicationContext(),"Successfully added!", Toast.LENGTH_LONG).show();
            }
        });

        horror2Button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                myRef.child("DRAKCASTLE").setValue("Horror: Dark Castle");
                Toast.makeText(getApplicationContext(),"Successfully added!", Toast.LENGTH_LONG).show();
            }
        });

        horror3Button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                myRef.child("FRANKENSTEIN").setValue("Horror: Frankenstein");
                Toast.makeText(getApplicationContext(),"Successfully added!", Toast.LENGTH_LONG).show();
            }
        });
    }
}

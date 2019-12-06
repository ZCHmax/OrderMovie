// Chenqian Cao

package com.example.ordermovie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CategoryAnimation extends AppCompatActivity {
    private DatabaseReference myRef;
    private FirebaseDatabase database;

    private String animation = "";
    private Button animation1Button;
    private Button animation2Button;
    private Button animation3Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_animation);

        animation1Button = (Button) findViewById(R.id.animation1Button);
        animation2Button = (Button) findViewById(R.id.animation2Button);
        animation3Button = (Button) findViewById(R.id.animation3Button);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("movies");

        animation1Button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                myRef.child("DESPICABLE").setValue("Animation: Despicable");
                Toast.makeText(getApplicationContext(),"Successfully added!", Toast.LENGTH_LONG).show();
            }
        });

        animation2Button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                myRef.child("MALEFICENT").setValue("Animation: Maleficent");
                Toast.makeText(getApplicationContext(),"Successfully added!", Toast.LENGTH_LONG).show();
            }
        });

        animation3Button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                myRef.child("INCREDIBLES").setValue("Animation: Incredibles");
                Toast.makeText(getApplicationContext(),"Successfully added!", Toast.LENGTH_LONG).show();
            }
        });
    }
}

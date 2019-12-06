// Zhenhao Sun

package com.example.ordermovie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CategoryComedy extends AppCompatActivity {
    private DatabaseReference myRef;
    private FirebaseDatabase database;

    private String comdey = "";
    private Button comedy1Button;
    private Button comedy2Button;
    private Button comedy3Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_comedy);

        comedy1Button = (Button) findViewById(R.id.comedy1Button);
        comedy2Button = (Button) findViewById(R.id.comedy2Button);
        comedy3Button = (Button) findViewById(R.id.comedy3Button);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("movies");

        comedy1Button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                myRef.child("3IDIOTS").setValue("Comedy: 3 Idiots");
                Toast.makeText(getApplicationContext(),"Successfully added!", Toast.LENGTH_LONG).show();
            }
        });

        comedy2Button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                myRef.child("SHAZAM").setValue("Comedy: Shazam");
                Toast.makeText(getApplicationContext(),"Successfully added!", Toast.LENGTH_LONG).show();
            }
        });

        comedy3Button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                myRef.child("FORRESTGUMP").setValue("Comedy: Forrest Gump");
                Toast.makeText(getApplicationContext(),"Successfully added!", Toast.LENGTH_LONG).show();
            }
        });
    }
}

// Chenghui Zhang

package com.example.ordermovie;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SeeCart extends AppCompatActivity {

    private DatabaseReference myRef;
    private FirebaseDatabase database;
    private ArrayList<String> movies = new ArrayList<>();
    private ListView mListView;

    private Button cleanButton;
    private Button searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_cart);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("movies");

        mListView = (ListView) findViewById(R.id.ListView);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, movies);
        mListView.setAdapter(arrayAdapter);
        cleanButton = (Button) findViewById(R.id.cleanButton);
        searchButton = (Button) findViewById(R.id.searchButton);

        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String value = dataSnapshot.getValue(String.class);
                movies.add(value);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                movies.remove(value);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        cleanButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                EditText movie = (EditText) findViewById( R.id.editText);
                String movieName = movie.getText().toString().toUpperCase().replaceAll("\\s", "");
                myRef.child(movieName).removeValue();
                movie.setText("");
            }
        });

        searchButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        EditText movie = (EditText) findViewById(R.id.editText2);
                        String movieName = movie.getText().toString().toUpperCase().replaceAll("\\s", "");;
                        if (dataSnapshot.hasChild(movieName)) {
                            Toast.makeText(getApplicationContext(),movieName + " already in Cart!", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getApplicationContext(),movieName + " not in Cart!", Toast.LENGTH_LONG).show();
                        }
                        movie.setText("");
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }

        });
    }
}

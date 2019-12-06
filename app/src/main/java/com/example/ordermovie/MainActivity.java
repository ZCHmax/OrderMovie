// Chenghui Zhang

package com.example.ordermovie;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    private Button actionButton;
    private Button comedyButton;
    private Button horrorButton;
    private Button animationButton;
    private Button myCartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionbar = getSupportActionBar();
        actionButton = (Button) findViewById(R.id.actionButton);
        comedyButton = (Button) findViewById(R.id.comedyButton);
        horrorButton = (Button) findViewById(R.id.horrorButton);
        animationButton = (Button) findViewById(R.id.animationButton);
        myCartButton = (Button) findViewById(R.id.myCartButton);

        actionButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                openAction();
            }
        });

        comedyButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                openComedy();
            }
        });

        horrorButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                openHorror();
            }
        });

        animationButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                openAnimation();
            }
        });

        myCartButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                openCart();
            }
        });
    }

    public void openAction() {
        Intent intent = new Intent(this,CategoryAction.class);
        startActivity(intent);
    }

    public void openComedy() {
        Intent intent = new Intent(this,CategoryComedy.class);
        startActivity(intent);
    }

    public void openHorror() {
        Intent intent = new Intent(this,CategoryHorror.class);
        startActivity(intent);
    }

    public void openAnimation() {
        Intent intent = new Intent(this,CategoryAnimation.class);
        startActivity(intent);
    }

    public void openCart() {
        Intent intent = new Intent(this,SeeCart.class);
        startActivity(intent);
    }
}

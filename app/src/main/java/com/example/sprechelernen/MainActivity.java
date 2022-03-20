package com.example.sprechelernen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    String verbenfileName, nomenfileName, adjfileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        verbenfileName = "verben.csv";
        nomenfileName = "nomen.csv";
        adjfileName = "adjektiv.csv";
    }

    public void goToVerb(View view){
        Intent i = new Intent(MainActivity.this,ExerciseActivity.class);
        i.putExtra("fileName", verbenfileName);
        startActivity(i);
    }

    public void goToNomen(View view){
        Intent i = new Intent(MainActivity.this,ExerciseActivity.class);
        i.putExtra("fileName", nomenfileName);
        startActivity(i);
    }

    public void goToAdj(View view){
        Intent i = new Intent(MainActivity.this,ExerciseActivity.class);
        i.putExtra("fileName", adjfileName);
        startActivity(i);
    }


}
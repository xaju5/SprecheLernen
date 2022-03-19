package com.example.sprechelernen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    String verbenFile, nomenFile, adjFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        verbenFile = new String("verben.csv");
        nomenFile = new String("nomen.csv");
        adjFile = new String("adjektiv.csv");
    }

    public void goToVerb(View view){
        Intent i = new Intent(MainActivity.this,ExerciseActivity.class);
        i.putExtra("file", verbenFile);
        startActivity(i);
    }

    public void goToNomen(View view){
        Intent i = new Intent(MainActivity.this,ExerciseActivity.class);
        i.putExtra("file", nomenFile);
        startActivity(i);
    }

    public void goToAdj(View view){
        Intent i = new Intent(MainActivity.this,ExerciseActivity.class);
        i.putExtra("file", adjFile);
        startActivity(i);
    }


}
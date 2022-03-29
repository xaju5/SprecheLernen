package com.example.sprechelernen;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private int verbenCode = 1;
    private int nomenCode = 2;
    private int adjCode = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToVerb(View view){
        Intent i = new Intent(MainActivity.this,ExerciseActivity.class);
        i.putExtra("code", verbenCode);
        startActivity(i);
    }

    public void goToNomen(View view){
        Intent i = new Intent(MainActivity.this,ExerciseActivity.class);
        i.putExtra("code", nomenCode);
        startActivity(i);
    }

    public void goToAdj(View view){
        Intent i = new Intent(MainActivity.this,ExerciseActivity.class);
        i.putExtra("code", adjCode);
        startActivity(i);
    }


}
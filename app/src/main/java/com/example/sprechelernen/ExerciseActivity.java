package com.example.sprechelernen;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ExerciseActivity extends AppCompatActivity {

    private TextView attemptsTV, questionTV, typeTV;
    private EditText answerET;
    private String rightAnswer, filename, questionStr, typeStr;
    private String[] exerWords;
    private List<String[]> allWords;
    private int attemptsNum;

    private String verbenfileName, nomenfileName, adjfileName;
    private String PATH = "/data/data/com.example.sprechelernen/data/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        attemptsTV = findViewById(R.id.attemptstextView);
        questionTV = findViewById(R.id.questiontextView);
        typeTV = findViewById(R.id.typeTextView);
        answerET = findViewById(R.id.answereditText);

        int code = 0;
        Bundle extras = getIntent().getExtras();
        if (extras != null){
            code = extras.getInt("code");
        }

        File file = null;
        if(code == 1){
            file = new File(getFilesDir()+"/data/verben.csv");
        }
        if(code == 2){
            file = new File(getFilesDir()+"/data/nomen.csv");
        }
        if(code == 3){
            file = new File(getFilesDir()+"/data/adjektiv.csv");
        }

        if(file.exists()){
            CSVReader csvReader = new CSVReader(ExerciseActivity.this,file.getPath());
            try {
                allWords = csvReader.readCSV();
            } catch (IOException e){
                e.printStackTrace();
                Toast toastFileError = Toast.makeText(getApplicationContext(),"File reader error",Toast.LENGTH_SHORT);
                toastFileError.show();

                //Error array
                String[] errorStr = {"ERROR","ERROR","ERROR"};
                allWords = new ArrayList<String[]>();
                allWords.add(errorStr);
                allWords.add(errorStr);
            }
        }
        else{
            Toast toastNotFile = Toast.makeText(getApplicationContext(),"File does not exist",Toast.LENGTH_SHORT);
            toastNotFile.show();
        }

        //chooseExerWords();
        //chooseQuestion();
        //updateTextView();
    }

    private  void chooseExerWords(){
        attemptsNum = 0;
        int randNum = new Random().nextInt(allWords.size() + 1) + 1;
        exerWords = allWords.get(randNum);
    }

    private void chooseQuestion(){
        int randNum = new Random().nextInt(exerWords.length);

        rightAnswer = exerWords[randNum];
        typeStr = allWords.get(0)[randNum];

        if(randNum != 0){
            questionStr = exerWords[0];
        }
        else{
            int randNum2 = new Random().nextInt(exerWords.length - 1) + 1;
            questionStr = exerWords[randNum2];
        }
    }

    private void updateTextView(){
        attemptsTV.setText(attemptsNum);
        questionTV.setText(questionStr);
        typeTV.setText(typeStr);
    }



}
package com.example.sprechelernen;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class ExerciseActivity extends AppCompatActivity {

    private TextView attemptsTV, questionTV, typeTV;
    private EditText answerET;
    private String rightAnswer, path, fileName, questionStr, typeStr;
    private String[] exerWords;
    private List<String[]> allWords;
    private int attemptsNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            fileName = extras.getString("fileName");
        }

        attemptsTV = findViewById(R.id.attemptstextView);
        questionTV = findViewById(R.id.questiontextView);
        typeTV = findViewById(R.id.typeTextView);
        answerET = findViewById(R.id.answereditText);

        CSVReader csvReader = new CSVReader(ExerciseActivity.this,fileName);
        try {
            allWords = csvReader.readCSV();
        } catch (IOException e){
            e.printStackTrace();
        }

        chooseExerWords();
        chooseQuestion();
        updateTextView();
    }

    private  void chooseExerWords(){
        attemptsNum = 0;
        int randNum = new Random().nextInt(allWords.size() + 1) + 1;
        exerWords = allWords.get(randNum);
    }

    private void chooseQuestion(){
        int randNum = new Random().nextInt(exerWords.length);

        if(randNum != 0){
            questionStr = exerWords[0];
            rightAnswer = exerWords[randNum];
            typeStr = allWords.get(0)[randNum];
        }
        else{
            int randNum2 = new Random().nextInt(exerWords.length);
            questionStr = exerWords[randNum2];
            rightAnswer = exerWords[randNum];
            typeStr = allWords.get(0)[randNum];
        }
    }

    private void updateTextView(){
        attemptsTV.setText(attemptsNum);
        questionTV.setText(questionStr);
        typeTV.setText(typeStr);
    }



}
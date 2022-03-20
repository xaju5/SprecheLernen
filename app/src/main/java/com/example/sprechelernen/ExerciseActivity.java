package com.example.sprechelernen;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class ExerciseActivity extends AppCompatActivity {

    TextView attemptsTV, questionTV, typeTV;
    EditText answerET;
    String rightAnswer, path, fileName;
    String[] exerWords;
    List<String[]> allWords;
    int attemptsNum;

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

        chooseWord();
        displayWord();

    }

    private  void chooseWord(){
        attemptsNum = 0;
        int randNum = new Random().nextInt(allWords.size() + 1);
        exerWords = allWords.get(randNum);
    }

    private void displayWord(){
        if (fileName == "nomen.csv"){
            String[] values = {"singular", "plural", "genero", "traducción"};
            selectQuestion(exerWords.length,values);
        }
        if(fileName == "adjektiv.csv"){
            String[] values = {"aleman", "traducción"};
            selectQuestion(exerWords.length,values);
        }
        if(fileName == "verben.csv"){
            String[] values = {"infinitivo", "participio", "traducción"};
            selectQuestion(exerWords.length,values);
        }

        //TODO asignar valores a los text view
    }

    private void selectQuestion(int maxNum, String[] values){
        int randNum = new Random().nextInt(exerWords.length);
        String questionStr, answerStr, typeStr;
        if(randNum != 0){
            questionStr = exerWords[0];
            answerStr = exerWords[randNum];
            typeStr = values[randNum];
        }
        else{
            int randNum2 = new Random().nextInt(exerWords.length);
            questionStr = exerWords[randNum2];
            answerStr = exerWords[randNum];
            typeStr = values[randNum];
        }

    }
}
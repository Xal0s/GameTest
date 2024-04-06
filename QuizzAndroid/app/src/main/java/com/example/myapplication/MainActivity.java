package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button playBtn = findViewById(R.id.playBtn);
        playBtn.setOnClickListener(view -> {

            Intent questionSerie = new Intent(MainActivity.this, GameSerieActivity.class);
            questionSerie.putExtra("questionList", new Quizz(Game.getSelectedQuestions(3)));

            questionSerie.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(questionSerie);


        });

        Button questionChoice = findViewById(R.id.questionsChoice);
        questionChoice.setOnClickListener(view -> {
            Intent selectQuestion = new Intent(MainActivity.this, QuestionChoiceActivity.class);
            startActivity(selectQuestion);

        });

        Button exitBtn = findViewById(R.id.exit);
        exitBtn.setOnClickListener(
                view -> {
                    finishAffinity();
                }
        );
    }

}
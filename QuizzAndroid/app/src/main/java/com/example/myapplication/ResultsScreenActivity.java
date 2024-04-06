package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ResultsScreenActivity extends AppCompatActivity {
    private TextView scoreText;
    private TextView scoreComment;
    private int score;
    private Button menuBtn;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results_screen);

        score = getIntent().getIntExtra("SCORE", 0);

        scoreText = findViewById(R.id.scoreDisplay);
        scoreComment = findViewById(R.id.textCondition);
        scoreText.setText("Votre score est de : " + score);

        menuBtn = findViewById(R.id.menuBtnResults);
        menuBtn.setOnClickListener(
                view -> {
                    Intent intent = new Intent(ResultsScreenActivity.this,
                            MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                });
        /*if(score == 0){
            scoreComment.setText("Aïe, aïe, aïe, vous devriez arrêter de travailler et jouer un peu plus !");
        }else if(score == 1){
            scoreComment.setText("Votre manque de connaissance vidéoludique me consterne...");
        } else if (score == 2) {
            scoreComment.setText("Sois meilleur !");
        }else {
            scoreComment.setText("Un héros n'a pas besoin de parler.");
        }*/
    }
}
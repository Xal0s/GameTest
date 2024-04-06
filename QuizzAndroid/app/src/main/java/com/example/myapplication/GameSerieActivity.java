package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import java.io.Serializable;
import java.util.List;

public class GameSerieActivity extends AppCompatActivity {
    private int questionCount = 1;
    private TextView questionNbr;
    private TextView scoreText;

    private Quizz quizz;

    private static final String KEY_QUESTION_LIST = "questionList";
    private Button menuBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_serie);
        questionNbr = findViewById(R.id.questionNbr);
        scoreText = findViewById(R.id.scoreText);
         quizz =(Quizz) getIntent().getParcelableExtra("questionList");
        if (quizz != null && quizz.selectedQuestions != null) {
            Log.d("Test", "Nombre de questions dans Quizz après récupération : " + quizz.selectedQuestions.size());
        }
        Log.d("DEBUG", "init : " + quizz.toString());

        menuBtn = findViewById(R.id.menuBtn);
        menuBtn.setOnClickListener(
                view -> {
                    Intent intent = new Intent(GameSerieActivity.this,
                            MainActivity.class);
                    startActivity(intent);
                });
        displayQuestion(quizz.currentQuestionIndex);
        
    }

    private void handleAnswer(Button button) {
        String correctAnswer = quizz.selectedQuestions.get(quizz.currentQuestionIndex).getAnswer();
        if (button.getText().toString().equals(correctAnswer)) {
            Toast.makeText(this, "Bonne réponse!", Toast.LENGTH_SHORT).show();
            quizz.score++;
        } else {
            Toast.makeText(this, "Mauvaise réponse!", Toast.LENGTH_SHORT).show();
        }
        questionCount++;
        displayNextQuestion();
        updateCounter();
        updateScore();
    }

    private void displayNextQuestion() {
        quizz.currentQuestionIndex++;
        if (quizz.currentQuestionIndex < quizz.selectedQuestions.size()) {
            displayQuestion(quizz.currentQuestionIndex);
        } else {
            Intent intent = new Intent(this, ResultsScreenActivity.class);
            intent.putExtra("SCORE", quizz.score);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (quizz.selectedQuestions != null) {
            outState.putSerializable(KEY_QUESTION_LIST, (Serializable) quizz.selectedQuestions);
        }
        outState.putInt("SCORE_KEY", quizz.score);
        outState.putInt("QUESTION_COUNT_KEY", questionCount);
        outState.putInt("CURRENT_QUESTION_INDEX_KEY", quizz.currentQuestionIndex);
    }

    private void updateCounter() {
        questionNbr.setText(
                getString(
                        R.string.questionNbr,
                        questionCount
                )
        );
    }

    private void updateScore() {
        scoreText.setText("Score: " + quizz.score);
    }

    private void displayQuestion(int questionIndex) {
        if (questionIndex >= 0 && questionIndex < quizz.selectedQuestions.size()) {
            TextView textViewQuestion = findViewById(R.id.question);
            String questionText = quizz.selectedQuestions.get(questionIndex).getQuestion();
            List<String> choices = quizz.selectedQuestions.get(questionIndex).getChoices();

            textViewQuestion.setText(questionText);

            Button buttonChoiceA = findViewById(R.id.AnsA);
            Button buttonChoiceB = findViewById(R.id.AnsB);
            Button buttonChoiceC = findViewById(R.id.AnsC);
            Button buttonChoiceD = findViewById(R.id.AnsD);

            buttonChoiceA.setText(choices.get(0));
            buttonChoiceB.setText(choices.get(1));
            buttonChoiceC.setText(choices.get(2));
            buttonChoiceD.setText(choices.get(3));

            buttonChoiceA.setOnClickListener(v -> handleAnswer(buttonChoiceA));
            buttonChoiceB.setOnClickListener(v -> handleAnswer(buttonChoiceB));
            buttonChoiceC.setOnClickListener(v -> handleAnswer(buttonChoiceC));
            buttonChoiceD.setOnClickListener(v -> handleAnswer(buttonChoiceD));

            updateCounter();
            updateScore();
        }
    }
}
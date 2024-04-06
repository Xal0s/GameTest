package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import java.util.List;

public class QuestionChoiceActivity extends AppCompatActivity {

    private List<Questions> questions =Game.getAllQuestions();
    private QuestionsAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_choice);

        adapter = new QuestionsAdapter(questions);

        @SuppressLint({"WrongViewCast", "MissingInflatedId", "LocalSuppress"})
        RecyclerView recyclerView = findViewById(R.id.questionsList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        getIntent().setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

    }


}
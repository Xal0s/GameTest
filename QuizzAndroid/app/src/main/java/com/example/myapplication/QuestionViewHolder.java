package com.example.myapplication;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class QuestionViewHolder extends RecyclerView.ViewHolder {

    final TextView questionTextView;
    Questions questionss;

    public QuestionViewHolder(@NonNull View itemView) {
        super(itemView);

        questionTextView = itemView.findViewById(R.id.item_question);
        questionTextView.setOnClickListener(view -> {

            List<Questions> choicedQuestionList = new ArrayList<>();
            choicedQuestionList.add(questionss);

            Intent questionSerie = new Intent(itemView.getContext(), GameSerieActivity.class);
            questionSerie.putExtra("questionList", new Quizz(choicedQuestionList));
            itemView.getContext().startActivity(questionSerie);
        });
    }

    public void bind(Questions questions){

        questionss = questions;
        questionTextView.setText(questions.getQuestion());
    }
}
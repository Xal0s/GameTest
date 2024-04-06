package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class QuestionsAdapter extends RecyclerView.Adapter<QuestionViewHolder> {
    private List<Questions> allQuestions;
    private Context context;
    public QuestionsAdapter(List<Questions> questions) {
        this.allQuestions = questions;
        this.context = context;
        Log.d("MYTAG", "QuestionsAdapter questions="+questions);
        Log.d("MYTAG", "QuestionsAdapter questions="+allQuestions);
    }

    @NonNull
    @Override
    public QuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_select_question, parent, false);
        return new QuestionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionViewHolder holder, int position) {
        Questions questions = allQuestions.get(position);
        holder.bind(questions);
    }

    @Override
    public int getItemCount() {
        Log.d("MYTAG", "getItemCount questions="+allQuestions);
        return allQuestions.size();
    }
}

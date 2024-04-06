package com.example.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class Quizz implements Parcelable {
    List<Questions> selectedQuestions;
    int currentQuestionIndex;
    int score;

    @Override
    public String toString() {
        return "Quizz{" +
                "selectedQuestions=" + selectedQuestions +
                ", currentQuestionIndex=" + currentQuestionIndex +
                ", score=" + score +
                '}';
    }

    Quizz(List<Questions> selectedQuestions) {
        this.selectedQuestions = selectedQuestions;
    }

    protected Quizz(Parcel in) {
        selectedQuestions = new ArrayList<>();
        in.readList(selectedQuestions, Questions.class.getClassLoader());
        currentQuestionIndex = in.readInt();
        score = in.readInt();
    }

    public static final Creator<Quizz> CREATOR = new Creator<Quizz>() {
        @Override
        public Quizz createFromParcel(Parcel in) {
            return new Quizz(in);
        }

        @Override
        public Quizz[] newArray(int size) {
            return new Quizz[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeList(selectedQuestions);
        dest.writeInt(currentQuestionIndex);
        dest.writeInt(score);
    }
}

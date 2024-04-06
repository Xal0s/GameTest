package com.example.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.List;

public class Questions implements Parcelable {
    private String question;

    @Override
    public String toString() {
        return "Questions{" +
                "question='" + question + '\'' +
                ", choices=" + choices +
                ", answer='" + answer + '\'' +
                '}';
    }

    private List<String> choices;
    private String answer;

    public Questions(String question, List<String> choices, String answer) {
        this.question = question;
        this.choices = choices;
        this.answer = answer;
    }

    protected Questions(Parcel in) {
        question = in.readString();
        choices = in.createStringArrayList();
        answer = in.readString();
    }

    public static final Creator<Questions> CREATOR = new Creator<Questions>() {
        @Override
        public Questions createFromParcel(Parcel in) {
            return new Questions(in);
        }

        @Override
        public Questions[] newArray(int size) {
            return new Questions[size];
        }
    };

    public String getQuestion() {
        return question;
    }

    public List<String> getChoices() {
        return choices;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(question);
        dest.writeStringList(choices);
        dest.writeString(answer);
    }
}

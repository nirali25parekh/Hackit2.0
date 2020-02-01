package com.example.hackit20;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class QuizFragment extends Fragment {

    private QuestionLibrary mQuestionLibrary = new QuestionLibrary();
    private TextView mScoreView;
    private TextView mQuestionView;
    private Button mChoice1;
    private Button mChoice2;
    private Button mChoice3;
    private Button mQuit;
    private String mAnswer;
    private int mScore=0;
    private int mQuestionNumber=0;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.quiz_fragment_layout, container, false);
        mChoice1=v.findViewById(R.id.choice1);
        mChoice2=v.findViewById(R.id.choice2);
        mChoice3=v.findViewById(R.id.choice3);
        mQuit=v.findViewById(R.id.quit);
        mScoreView=v.findViewById(R.id.score);
        mQuestionView=v.findViewById(R.id.question);
        updateQuestion();

        mChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mChoice1.getText()==mAnswer){

                    mScore=mScore+1;
                    updateScore(mScore);
                    updateQuestion();
                    //Toast.makeText(this,"Correct!!!",Toast.LENGTH_SHORT).show();
                }else {

                    updateQuestion();
                }
            }
        });

        mChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mChoice2.getText()==mAnswer){

                    mScore=mScore+1;
                    updateScore(mScore);
                    updateQuestion();
                    //Toast.makeText(this,"Correct!!!",Toast.LENGTH_SHORT).show();
                }else {

                    updateQuestion();
                }
            }
        });

        mChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mChoice3.getText()==mAnswer){

                    mScore=mScore+1;
                    updateScore(mScore);
                    updateQuestion();
                    //Toast.makeText(this,"Correct!!!",Toast.LENGTH_SHORT).show();
                }else {

                    updateQuestion();
                }
            }
        });



        return v;

    }

    private void updateQuestion(){
        if(mQuestionNumber<mQuestionLibrary.length()) {
            mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
            mChoice1.setText(mQuestionLibrary.getChoice0(mQuestionNumber));
            mChoice2.setText(mQuestionLibrary.getChoice1(mQuestionNumber));
            mChoice3.setText(mQuestionLibrary.getChoice2(mQuestionNumber));
            mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);
            mQuestionNumber++;
        }

    }

    private void updateScore(int point){

        mScoreView.setText(""+point);
    }

}

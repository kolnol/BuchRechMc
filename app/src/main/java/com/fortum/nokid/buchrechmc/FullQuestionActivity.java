package com.fortum.nokid.buchrechmc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import io.realm.Realm;

public class FullQuestionActivity extends AppCompatActivity {

    private TextView textView;
    private Button answerA;
    private Button answerB;
    private Button answerC;
    private Button answerD;
    private Button prevButton;
    private Button nextButton;
    Question question;
    private Realm realm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.full_question);

        textView = (TextView) findViewById(R.id.fullQuestionText);
        answerA = (Button) findViewById(R.id.answerAButton);
        answerB = (Button) findViewById(R.id.answerBButton);
        answerC = (Button) findViewById(R.id.answerCButton);
        answerD = (Button) findViewById(R.id.answerDButton);
        nextButton = (Button) findViewById(R.id.nextButton);
        prevButton = (Button) findViewById(R.id.prevButton);

        final int position = getIntent().getIntExtra("position", 0);
         realm = MainActivity.realm;

        question=realm.allObjects(Question.class).get(position);

        textView.setText(question.getQuestion());
        answerA.setText(question.getPossibleAnswers().get(0).getString());
        answerB.setText(question.getPossibleAnswers().get(1).getString());
        answerC.setText(question.getPossibleAnswers().get(2).getString());
        answerD.setText(question.getPossibleAnswers().get(3).getString());

        answerA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isRight(answerA, 0);
            }
        });
        answerB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isRight(answerB, 1);
            }
        });
        answerC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isRight(answerC, 2);
            }
        });
        answerD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isRight(answerD,3);
            }
        });

        if(position+1==realm.allObjects(Question.class).size()){
            nextButton.setEnabled(false);
        }

        if(position==0){
            prevButton.setEnabled(false);
        }

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToNextQuestion(v, position);
            }
        });

        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToPrevQuestion(v,position);
            }
        });
    }

    private void goToPrevQuestion(View v, int position) {
        Intent intent = new Intent(MainActivity.contextMain,FullQuestionActivity.class);
        intent.putExtra("position", position-1);
        MainActivity.contextMain.startActivity(intent);
    }

    private void goToNextQuestion(View v,int position) {
        Intent intent = new Intent(MainActivity.contextMain,FullQuestionActivity.class);
        intent.putExtra("position", position+1);
        MainActivity.contextMain.startActivity(intent);
    }

    public void isRight(Button button,int answer){
        if(question.getRightAnswerIndex()==answer){
            button.setBackgroundColor(getResources().getColor(R.color.rightAnswerColor));
        }else{
            button.setBackgroundColor(getResources().getColor(R.color.wrongAnswerColor));
        }

    }

    @Override
    public void onPause() {
        super.onPause();
        finish();
    }

}

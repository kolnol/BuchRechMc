package com.fortum.nokid.buchrechmc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import io.realm.Realm;
import io.realm.RealmResults;

public class FullQuestionActivity extends AppCompatActivity {

    private TextView textView;
    private Button answerA;
    private Button answerB;
    private Button answerC;
    private Button answerD;
    private Button prevButton;
    private Button nextButton;
    private Question question;
    private Realm realm;
    private RealmResults<Question> result;


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
        realm = MainActivity.realm;

        final int position = getIntent().getIntExtra("position", 0);
        final int from = getIntent().getIntExtra("fromPosition", 0);
        final int to = getIntent().getIntExtra("toPosition", realm.allObjects(Question.class).size());

        result=realm.where(Question.class).between("id",from,to).findAllSorted("id");
        question=result.get(position);

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

        if(position+1==result.size()||from==to){
            nextButton.setEnabled(false);
        }

        if(position==0||from==to){
            prevButton.setEnabled(false);
        }

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToNextQuestion(v, position,from,to);
            }
        });

        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToPrevQuestion(v, position,from,to);
            }
        });
    }

    private void goToPrevQuestion(View v, int position,int from,int to) {
        Intent intent = new Intent(MainActivity.contextMain,FullQuestionActivity.class);
        intent.putExtra("position", position-1);
        intent.putExtra("fromPosition", from);
        intent.putExtra("toPosition", to);
        MainActivity.contextMain.startActivity(intent);
    }

    private void goToNextQuestion(View v,int position,int from,int to) {
        Intent intent = new Intent(MainActivity.contextMain,FullQuestionActivity.class);
        intent.putExtra("position", position+1);
        intent.putExtra("fromPosition", from);
        intent.putExtra("toPosition", to);
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

    private void initResult(int from,int to){

    }

}

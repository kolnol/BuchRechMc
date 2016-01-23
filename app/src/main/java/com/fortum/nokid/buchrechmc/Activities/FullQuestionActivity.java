package com.fortum.nokid.buchrechmc.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.fortum.nokid.buchrechmc.Entities.Question;
import com.fortum.nokid.buchrechmc.R;
import com.fortum.nokid.buchrechmc.RealmClasses.RealmBoolean;
import com.fortum.nokid.buchrechmc.Sprint.Sprint;
import com.fortum.nokid.buchrechmc.Sprint.SprintResultActivity;

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
    private int countQuestions;
    private boolean isSprint;
    private Sprint sprint;
    private boolean answered;


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
        isSprint = getIntent().getBooleanExtra("isSprint", false);

        //Init DB and find Question
        if(!isSprint){
            result=realm.where(Question.class).between("id",from,to).findAllSorted("id");
        }else{
            sprint=realm.allObjects(Sprint.class).last();
            result=sprint.getQuestions().where().findAll();
        }
        question=result.get(position);

        //Set Question and answers to view
        textView.setText(question.getQuestion());
        answerA.setText(question.getPossibleAnswers().get(0).getString());
        answerB.setText(question.getPossibleAnswers().get(1).getString());
        answerC.setText(question.getPossibleAnswers().get(2).getString());
        answerD.setText(question.getPossibleAnswers().get(3).getString());

        //Set for every answer function to check Answer
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
                isRight(answerD, 3);
            }
        });


        //Set Actions to next and previous buttons
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!answered){
                    saveAnswerToDB(false);
                }
                goToNextQuestion(v, position, from, to);
            }
        });

        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!answered){
                    saveAnswerToDB(false);
                }
                goToPrevQuestion(v, position,from,to);
            }
        });

        //Check if there are another Question or it is end of the list
        if(position+1==result.size()||from==to||(0==countQuestions-1)){
            if(isSprint){
                nextButton.setText("Finish");
                nextButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(v.getContext(),SprintResultActivity.class);
                        v.getContext().startActivity(intent);
                    }
                });

            }else{
                nextButton.setEnabled(false);
            }
        }

        //Check behaviour for previous button
        if(position==0||from==to||isSprint){
            prevButton.setEnabled(false);
        }

    }

    private void goToPrevQuestion(View v, int position,int from,int to) {
        Intent intent = new Intent(MainActivity.contextMain,FullQuestionActivity.class);
        intent.putExtra("position", position - 1);
        intent.putExtra("fromPosition", from);
        intent.putExtra("toPosition", to);

        MainActivity.contextMain.startActivity(intent);
    }

    private void goToNextQuestion(View v,int position,int from,int to) {
        Intent intent = new Intent(MainActivity.contextMain,FullQuestionActivity.class);
        intent.putExtra("position", position + 1);
        intent.putExtra("fromPosition", from);
        intent.putExtra("toPosition", to);
        if(isSprint){
            intent.putExtra("isSprint",true);
        }
        MainActivity.contextMain.startActivity(intent);
    }

    public void isRight(Button button,int answer){
        answered=true;
        if(question.getRightAnswerIndex()==answer){

            saveAnswerToDB(true);
            button.setBackgroundColor(getResources().getColor(R.color.rightAnswerColor));
        }else{
            saveAnswerToDB(false);
            button.setBackgroundColor(getResources().getColor(R.color.wrongAnswerColor));

            switch (question.getRightAnswerIndex()){
                case 0:
                    button=answerA;
                    break;
                case 1:
                    button=answerB;
                    break;
                case 2:
                    button=answerC;
                    break;
                case 3:
                    button=answerD;
                    break;
                default:
                    //TODO throw new IllegalStateException();

            }
            button.setBackgroundColor(getResources().getColor(R.color.rightAnswerColor));

        }
        answerA.setClickable(false);
        answerB.setClickable(false);
        answerC.setClickable(false);
        answerD.setClickable(false);
    }

    private void saveAnswerToDB(boolean res){
        realm.beginTransaction();
        question.setIsRightAnswered(res);

        if(isSprint){
            sprint.getAnswerTrigger().add(new RealmBoolean(res));
            realm.copyToRealm(sprint);
        }

        realm.commitTransaction();
    }

    @Override
    public void onPause() {
        super.onPause();
        finish();
    }
}

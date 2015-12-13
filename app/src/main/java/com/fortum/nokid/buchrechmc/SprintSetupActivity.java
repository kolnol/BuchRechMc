package com.fortum.nokid.buchrechmc;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import io.realm.Realm;


public class SprintSetupActivity extends AppCompatActivity {
    private EditText questionsCount;
    private Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sprint_setup_activity);

        questionsCount=(EditText)findViewById(R.id.questionsCountSprint);
        startButton=(Button)findViewById(R.id.sprintStartButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    int count=Integer.parseInt(questionsCount.getText().toString());
                    if(isValid(v,count)){
                        goToFullSprintActivity(count);
                    }
                }catch (NumberFormatException e){
                    Snackbar.make(v, "Anzahl an Fragen ist ungültig.",Snackbar.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void goToFullSprintActivity(int count) {
        Intent intent = new Intent(MainActivity.contextMain,FullQuestionActivity.class);
        Realm realm=MainActivity.realm;
        intent.putExtra("isSprint", true);

        realm.beginTransaction();
        realm.clear(Sprint.class);

        Sprint sprint=new Sprint(count);
        SprintLogic.initQuestions(sprint);

        realm.copyToRealm(sprint);
        realm.commitTransaction();

        startActivity(intent);
    }

    private boolean isValid(View v,int count){

        int realmSize=MainActivity.realm.allObjects(Question.class).size();

        if(count>realmSize){
            Snackbar.make(v, "Anzahl an Fragen ist zu groß. Maximale Anzahl ist "+realmSize, Snackbar.LENGTH_LONG).show();
            return false;
        }else if(count==0||count<0){
            Snackbar.make(v, "Anzahl an Fragen ist ungültig.",Snackbar.LENGTH_LONG).show();
            return false;
        }else{
            return true;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}

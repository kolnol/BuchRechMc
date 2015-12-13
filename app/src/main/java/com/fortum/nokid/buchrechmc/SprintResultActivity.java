package com.fortum.nokid.buchrechmc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class SprintResultActivity extends AppCompatActivity {
    private TextView resultTextView;
    private Button finishButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sprint_result_layout);

        resultTextView=(TextView) findViewById(R.id.resultTextView);
        finishButton=(Button) findViewById(R.id.sprintFinishButton);

        Sprint sprint = MainActivity.realm.allObjects(Sprint.class).last();

        resultTextView.setText(SprintLogic.generateResult(sprint));

        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

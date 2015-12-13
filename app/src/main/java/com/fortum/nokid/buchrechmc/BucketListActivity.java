package com.fortum.nokid.buchrechmc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import io.realm.RealmResults;

public class BucketListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RealmResults results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bucket_list_layout);

        recyclerView=(RecyclerView) findViewById(R.id.bucketQuestionsList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        results = MainActivity.realm.where(Question.class).equalTo("isRightAnswered",true).findAll();

        QuestionsAdapterRecycleView adapter = new QuestionsAdapterRecycleView(results,this);

        recyclerView.setAdapter(adapter);

    }
}

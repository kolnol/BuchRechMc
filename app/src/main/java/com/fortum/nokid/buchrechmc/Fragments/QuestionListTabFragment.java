package com.fortum.nokid.buchrechmc.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fortum.nokid.buchrechmc.Activities.MainActivity;
import com.fortum.nokid.buchrechmc.Adapters.QuestionsAdapterRecycleView;
import com.fortum.nokid.buchrechmc.Entities.Question;
import com.fortum.nokid.buchrechmc.R;

import io.realm.Realm;
import io.realm.RealmResults;
public class QuestionListTabFragment extends Fragment{


    private RecyclerView recyclerView;
    private RealmResults<Question> results;

    public QuestionListTabFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.question_list_tab_layout, container, false);

        Realm realm = MainActivity.realm;

        recyclerView=(RecyclerView)v.findViewById(R.id.questionsList);

        recyclerView.setLayoutManager(new LinearLayoutManager(v.getContext()));

        //TODO
        //results = realm.where(Question.class).between("id", 0, realm.allObjects(Question.class).size() - 1).findAll();
        results=realm.where(Question.class).findAll();

        QuestionsAdapterRecycleView adapter = new QuestionsAdapterRecycleView(results,v.getContext());

        recyclerView.setAdapter(adapter);

        return v;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }



}

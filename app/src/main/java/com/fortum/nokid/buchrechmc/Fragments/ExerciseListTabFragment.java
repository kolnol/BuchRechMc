package com.fortum.nokid.buchrechmc.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fortum.nokid.buchrechmc.Activities.MainActivity;
import com.fortum.nokid.buchrechmc.Adapters.ExerciseAdapterRecyclerView;
import com.fortum.nokid.buchrechmc.Entities.Exercise;
import com.fortum.nokid.buchrechmc.R;

import io.realm.Realm;
import io.realm.RealmResults;


public class ExerciseListTabFragment extends Fragment {


    private RecyclerView recyclerView;
    private RealmResults<Exercise> results;

    public ExerciseListTabFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.exercise_list_tab_layout, container, false);

        Realm realm = MainActivity.realm;

        recyclerView=(RecyclerView)v.findViewById(R.id.exerciseList);

        recyclerView.setLayoutManager(new LinearLayoutManager(v.getContext()));

        //TODO
        results = realm.where(Exercise.class).findAll();

        ExerciseAdapterRecyclerView adapter = new ExerciseAdapterRecyclerView(results,v.getContext());

        recyclerView.setAdapter(adapter);

        return v;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


}

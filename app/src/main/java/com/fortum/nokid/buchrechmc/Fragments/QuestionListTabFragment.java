package com.fortum.nokid.buchrechmc.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.fortum.nokid.buchrechmc.Activities.MainActivity;
import com.fortum.nokid.buchrechmc.Adapters.QuestionsAdapterRecycleView;
import com.fortum.nokid.buchrechmc.AsyncTasks.GetAllQuestionsTask;
import com.fortum.nokid.buchrechmc.Entities.Question;
import com.fortum.nokid.buchrechmc.Entities.User;
import com.fortum.nokid.buchrechmc.R;

import java.util.concurrent.ExecutionException;

import io.realm.Realm;
import io.realm.RealmResults;
public class QuestionListTabFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {


    private RecyclerView recyclerView;
    private RealmResults<Question> results;
    private SwipeRefreshLayout swipeContainer;

    public QuestionListTabFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v=inflater.inflate(R.layout.question_list_tab_layout, container, false);

        Realm realm = MainActivity.realm;

        recyclerView=(RecyclerView)v.findViewById(R.id.questionsList);

        recyclerView.setLayoutManager(new LinearLayoutManager(v.getContext()));

        //TODO
        //results = realm.where(Question.class).between("id", 0, realm.allObjects(Question.class).size() - 1).findAll();
        results=realm.where(Question.class).findAll();

        QuestionsAdapterRecycleView adapter = new QuestionsAdapterRecycleView(results,v.getContext());

        recyclerView.setAdapter(adapter);

        swipeContainer = (SwipeRefreshLayout) v.findViewById(R.id.swipeContainer);
        swipeContainer.setOnRefreshListener(this);

        swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);


        return v;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public void onRefresh() {
        // Your code to refresh the list here.
        // Make sure you call swipeContainer.setRefreshing(false)
        // once the network request has completed successfully.
        Realm realm = Realm.getDefaultInstance();//Todo refactor it
        User user = realm.where(User.class).findFirst();
        Toast.makeText(this.getActivity().getApplicationContext(),"Getting Questions",Toast.LENGTH_LONG).show();
        GetAllQuestionsTask getAllQuestionsTask = new GetAllQuestionsTask(this.getActivity().getApplicationContext());
        getAllQuestionsTask.execute(user.getSessionId());

        try {
            realm.beginTransaction();
            realm.createOrUpdateAllFromJson(Question.class, getAllQuestionsTask.get());
            realm.commitTransaction();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
            Toast.makeText(this.getActivity().getApplicationContext(),"There was a problem with connection.",Toast.LENGTH_LONG).show();
        }

        swipeContainer.setRefreshing(false);
    }
}

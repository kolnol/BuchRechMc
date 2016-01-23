package com.fortum.nokid.buchrechmc.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fortum.nokid.buchrechmc.R;

public class ExerciseTextFragment extends Fragment {
    private TextView exerciseTextView;
    private TextView belegTextView;

    private String exerciseText;
    private String belegText;

    public ExerciseTextFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v= inflater.inflate(R.layout.exercise_text_page,container,false);

        exerciseTextView=(TextView)v.findViewById(R.id.exerciseTextView);
        belegTextView=(TextView) v.findViewById(R.id.belegTextView);

        if(belegText!=null && exerciseText!=null){
            exerciseTextView.setText(exerciseText);
            belegTextView.setText(belegText);
        }else{
            exerciseTextView.setText("Not found");
            belegTextView.setText("Not found");
        }
        return v;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        exerciseText=getArguments().getString("exerciseText");
        belegText=getArguments().getString("belegText");
    }

    public static ExerciseTextFragment newInstance(String exerciseText,String belegText) {
        ExerciseTextFragment myFragment = new ExerciseTextFragment();

        Bundle args = new Bundle();
        args.putString("exerciseText",exerciseText);
        args.putString("belegText",belegText);
        myFragment.setArguments(args);

        return myFragment;
    }
}

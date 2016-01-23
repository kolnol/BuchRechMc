package com.fortum.nokid.buchrechmc.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fortum.nokid.buchrechmc.Activities.FullExerciseActivity;
import com.fortum.nokid.buchrechmc.Entities.Exercise;
import com.fortum.nokid.buchrechmc.R;

import io.realm.RealmResults;

public class ExerciseAdapterRecyclerView extends RecyclerView.Adapter<ExerciseAdapterRecyclerView.ViewHolder> {
    private RealmResults<Exercise> exercises;
    private Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder  {
        public TextView txtViewTitle;
        public Exercise exercise;
        private String aktualleKapitel="1.0";

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);

            txtViewTitle = (TextView) itemLayoutView.findViewById(R.id.exerciseTextView);
        }

        public void setItem(Exercise exercise){
            this.exercise = exercise;
            txtViewTitle.setText(exercise.getAufgabeText());
            /*if(aktualleKapitel.equals("1.0")){
                txtViewTitle.setText("Grundlagen");
                this.aktualleKapitel="1.1";
            }else if(!aktualleKapitel.equals(question.getKapitel())){
                txtViewTitle.setText("Kapitel"+question.getKapitel().substring(0,1));
                this.aktualleKapitel=question.getKapitel().substring(0,1);
            }else{
                txtViewTitle.setText(question.getQuestion());
            }*/

        }

    }

    public ExerciseAdapterRecyclerView(RealmResults exercises,Context context){
        this.exercises=exercises;
        this.context=context;
    }

    public ExerciseAdapterRecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.exercise_item_layout,parent,false);
        ViewHolder viewHolder=new ViewHolder(itemLayoutView);
        return viewHolder;
    }



    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.setItem(exercises.get(position));
        holder.txtViewTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFullExercise(v, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return exercises.size();
    }

    public void goToFullExercise(View v,int position) {
        Intent intent = new Intent(context, FullExerciseActivity.class);
        intent.putExtra("position", position);
        context.startActivity(intent);
    }
}

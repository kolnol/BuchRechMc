package com.fortum.nokid.buchrechmc.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fortum.nokid.buchrechmc.Activities.FullQuestionActivity;
import com.fortum.nokid.buchrechmc.Entities.Question;
import com.fortum.nokid.buchrechmc.R;

import io.realm.RealmResults;


public class QuestionsAdapterRecycleView extends RecyclerView.Adapter<QuestionsAdapterRecycleView.ViewHolder> {
    private RealmResults<Question> questions;
    private Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder  {
        public TextView txtViewTitle;
        public Question question;


        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);

            txtViewTitle = (TextView) itemLayoutView.findViewById(R.id.questionTextView);
        }

        public void setItem(Question question){
            this.question = question;
            txtViewTitle.setText(question.getQuestion());
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

    public QuestionsAdapterRecycleView(RealmResults questions,Context context){
        this.questions=questions;
        this.context=context;
    }

    public QuestionsAdapterRecycleView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.question_layout,parent,false);
        ViewHolder viewHolder=new ViewHolder(itemLayoutView);
        return viewHolder;
    }



    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.setItem(questions.get(position));
        holder.txtViewTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFullQuestion(v, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    public void goToFullQuestion(View v,int position) {
        Intent intent = new Intent(context,FullQuestionActivity.class);
        intent.putExtra("position", position);
        context.startActivity(intent);
    }
}

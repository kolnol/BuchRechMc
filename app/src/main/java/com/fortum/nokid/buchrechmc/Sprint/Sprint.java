package com.fortum.nokid.buchrechmc.Sprint;

import com.fortum.nokid.buchrechmc.Entities.Question;
import com.fortum.nokid.buchrechmc.RealmClasses.RealmBoolean;
import com.fortum.nokid.buchrechmc.RealmClasses.RealmInteger;

import io.realm.RealmList;
import io.realm.RealmObject;


public class Sprint extends RealmObject {
    private RealmList<Question> questions;
    private RealmList<RealmBoolean> answerTrigger;
    private RealmList<RealmInteger> rightAnswered;
    private RealmList<RealmInteger> falseAnswered;
    private int count;


    public Sprint(int count) {
        this.count=count;
        answerTrigger=new RealmList<RealmBoolean>();
    }

    public Sprint() {
    }

    public RealmList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(RealmList<Question> questions) {
        this.questions = questions;
    }

    public RealmList<RealmBoolean> getAnswerTrigger() {
        return answerTrigger;
    }

    public void setAnswerTrigger(RealmList<RealmBoolean> answerTrigger) {
        this.answerTrigger = answerTrigger;
    }

    public RealmList<RealmInteger> getRightAnswered() {
        return rightAnswered;
    }

    public void setRightAnswered(RealmList<RealmInteger> rightAnswered) {
        this.rightAnswered = rightAnswered;
    }

    public RealmList<RealmInteger> getFalseAnswered() {
        return falseAnswered;
    }

    public void setFalseAnswered(RealmList<RealmInteger> falseAnswered) {
        this.falseAnswered = falseAnswered;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}


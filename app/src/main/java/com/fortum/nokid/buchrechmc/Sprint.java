package com.fortum.nokid.buchrechmc;

import io.realm.RealmList;
import io.realm.RealmObject;


public class Sprint extends RealmObject {
    private RealmList<Question> questions;
    private RealmList<RealmBoolean> answerTrigger;
    private RealmList<IntegerRealm> rightAnswered;
    private RealmList<IntegerRealm> falseAnswered;
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

    public RealmList<IntegerRealm> getRightAnswered() {
        return rightAnswered;
    }

    public void setRightAnswered(RealmList<IntegerRealm> rightAnswered) {
        this.rightAnswered = rightAnswered;
    }

    public RealmList<IntegerRealm> getFalseAnswered() {
        return falseAnswered;
    }

    public void setFalseAnswered(RealmList<IntegerRealm> falseAnswered) {
        this.falseAnswered = falseAnswered;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}


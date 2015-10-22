package com.fortum.nokid.buchrechmc;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by Nokid on 20/10/15.
 */
public class User extends RealmObject{
    private String name;
    private int score;
    private RealmList<Question> doneQuestions;
    private int id;

    public User() {
        this.score=0;
        this.doneQuestions=new RealmList<>();

    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public RealmList<Question> getDoneQuestions() {
        return doneQuestions;
    }

    public void setDoneQuestions(RealmList<Question> doneQuestions) {
        this.doneQuestions = doneQuestions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

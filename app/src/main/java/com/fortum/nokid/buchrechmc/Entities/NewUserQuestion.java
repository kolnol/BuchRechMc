package com.fortum.nokid.buchrechmc.Entities;

import io.realm.RealmObject;

/**
 * Created by Nokid on 19/10/2016.
 */

public class NewUserQuestion extends RealmObject{
    private int id;

    private NewUser user;

    private NewQuestion question;

    private boolean tried;

    private boolean correctlyAnswered;

    private NewAnswer givenAnswer;

    public NewUserQuestion() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public NewUser getUser() {
        return user;
    }

    public void setUser(NewUser user) {
        this.user = user;
    }

    public NewQuestion getQuestion() {
        return question;
    }

    public void setQuestion(NewQuestion question) {
        this.question = question;
    }

    public boolean isTried() {
        return tried;
    }

    public void setTried(boolean tried) {
        this.tried = tried;
    }

    public boolean isCorrectlyAnswered() {
        return correctlyAnswered;
    }

    public void setCorrectlyAnswered(boolean correctlyAnswered) {
        this.correctlyAnswered = correctlyAnswered;
    }

    public NewAnswer getGivenAnswer() {
        return givenAnswer;
    }

    public void setGivenAnswer(NewAnswer givenAnswer) {
        this.givenAnswer = givenAnswer;
    }
}

package com.fortum.nokid.buchrechmc.Entities;

import io.realm.RealmObject;

/**
 * Created by Nokid on 22/08/16.
 */
public class UserQuestion extends RealmObject{

    private int id;

    private User user;

    private Question question;

    private boolean tried;

    private boolean correctlyAnswered;

    private Answer givenAnswer;


    public UserQuestion() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
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

    public Answer getGivenAnswer() {
        return givenAnswer;
    }

    public void setGivenAnswer(Answer givenAnswer) {
        this.givenAnswer = givenAnswer;
    }
}

package com.fortum.nokid.buchrechmc.Entities;

import io.realm.RealmList;
import io.realm.RealmModel;
import io.realm.annotations.RealmClass;

/**
 * Created by Nokid on 22/08/16.
 */
@RealmClass
public class Answer implements RealmModel {

    private int id;

    private Question question;

    private int answerId;

    private String answer;

    private RealmList<UserQuestion> userQuestions;

    public Answer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public RealmList<UserQuestion> getUserQuestions() {
        return userQuestions;
    }



    public void setUserQuestions(RealmList<UserQuestion> userQuestions) {
        this.userQuestions = userQuestions;
    }
}

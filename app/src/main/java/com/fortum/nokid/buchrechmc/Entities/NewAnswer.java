package com.fortum.nokid.buchrechmc.Entities;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by Nokid on 19/10/2016.
 */

public class NewAnswer extends RealmObject {
    private int id;

    private NewQuestion question;

    private int answerId;

    private String answer;

    private RealmList<NewUserQuestion> userQuestions;

    public NewAnswer() {
    }

    public NewAnswer(int id, NewQuestion question, int answerId, String answer, RealmList<NewUserQuestion> userQuestions) {
        this.id = id;
        this.question = question;
        this.answerId = answerId;
        this.answer = answer;
        this.userQuestions = userQuestions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public NewQuestion getQuestion() {
        return question;
    }

    public void setQuestion(NewQuestion question) {
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

    public RealmList<NewUserQuestion> getUserQuestions() {
        return userQuestions;
    }

    public void setUserQuestions(RealmList<NewUserQuestion> userQuestions) {
        this.userQuestions = userQuestions;
    }
}

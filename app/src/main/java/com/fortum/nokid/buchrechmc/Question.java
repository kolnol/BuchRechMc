package com.fortum.nokid.buchrechmc;




import io.realm.RealmList;
import io.realm.RealmObject;


public class Question extends RealmObject{
    private int id;
    private String question;
    private RealmList<RealmString> possibleAnswers;
    private int rightAnswerIndex;
    private String thema;
    private String kapitel;
    private String hint;

    public Question() {
    }

    public Question(int id, String question, RealmList<RealmString> possibleAnswers, int rightAnswerIndex, String hint) {
        this.id = id;
        this.question = question;
        this.possibleAnswers = possibleAnswers;
        this.rightAnswerIndex = rightAnswerIndex;
        this.hint = hint;
    }


    public Question(int id,String question,RealmList<RealmString> possibleAnswers,int rightAnswerIndex,String kapitel,String hint){
        this.id=id;
        this.question=question;
        this.possibleAnswers=possibleAnswers;
        this.rightAnswerIndex=rightAnswerIndex;

    }


    public Question(int id,String question,RealmList<RealmString> possibleAnswers,String kapitel,int rightAnswerIndex){
        this.id=id;
        this.question=question;
        this.possibleAnswers=possibleAnswers;
        this.rightAnswerIndex=rightAnswerIndex;

    }

    public Question(int id,String question,RealmList<RealmString> possibleAnswers,int rightAnswerIndex){
        this.id=id;
        this.question=question;
        this.possibleAnswers=possibleAnswers;
        this.rightAnswerIndex=rightAnswerIndex;

    }

    public RealmList<RealmString> getPossibleAnswers() {
        return possibleAnswers;
    }

    public void setPossibleAnswers(RealmList<RealmString> possibleAnswers) {
        this.possibleAnswers = possibleAnswers;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getRightAnswerIndex() {
        return rightAnswerIndex;
    }

    public void setRightAnswerIndex(int rightAnswerIndex) {
        this.rightAnswerIndex = rightAnswerIndex;
    }

    public String getThema() {
        return thema;
    }

    public void setThema(String thema) {
        this.thema = thema;
    }

    public String getKapitel() {
        return kapitel;
    }

    public void setKapitel(String kapitel) {
        this.kapitel = kapitel;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }
}

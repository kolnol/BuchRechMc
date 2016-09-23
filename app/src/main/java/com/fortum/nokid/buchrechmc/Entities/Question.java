package com.fortum.nokid.buchrechmc.Entities;

import io.realm.RealmList;
import io.realm.RealmObject;


public class Question extends RealmObject{
    private long id;
    private String content;
    private RealmList<Answer> possibleAnswers;
    private int correctAnswerId;
    private int chapter;
    private String hint;
    private boolean isRightAnswered;
    private boolean isBookingEntry;
    private int fromPage;
    private int toPage;



    public Question() {
    }

    public Question(long id, String content, RealmList<Answer> possibleAnswers, int correctAnswerId, String hint) {
        this.id = id;
        this.content = content;
        this.possibleAnswers = possibleAnswers;
        this.correctAnswerId = correctAnswerId;
        this.hint = hint;
        isRightAnswered=false;
    }
    public Question(int id, String content, RealmList<Answer> possibleAnswers, int correctAnswerId, String kapitel, String hint){
        this.id=id;
        this.content = content;
        this.possibleAnswers=possibleAnswers;
        this.correctAnswerId = correctAnswerId;
        isRightAnswered=false;
        this.kapitel=kapitel;
        this.hint=hint;
    }


    public Question(int id, String content, RealmList<Answer> possibleAnswers, String kapitel, int correctAnswerId){
        this.id=id;
        this.content = content;
        this.possibleAnswers=possibleAnswers;
        this.correctAnswerId = correctAnswerId;
        isRightAnswered=false;
        this.kapitel=kapitel;
    }

    public Question(int id, String content, RealmList<Answer> possibleAnswers, int correctAnswerId){
        this.id=id;
        this.content = content;
        this.possibleAnswers=possibleAnswers;
        this.correctAnswerId = correctAnswerId;
        isRightAnswered=false;
    }

    public boolean isRightAnswered() {
        return isRightAnswered;
    }

    public void setIsRightAnswered(boolean isRightAnswered) {
        this.isRightAnswered = isRightAnswered;
    }

    public RealmList<Answer> getPossibleAnswers() {
        return possibleAnswers;
    }

    public void setPossibleAnswers(RealmList<Answer> possibleAnswers) {
        this.possibleAnswers = possibleAnswers;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCorrectAnswerId() {
        return correctAnswerId;
    }

    public void setCorrectAnswerId(int correctAnswerId) {
        this.correctAnswerId = correctAnswerId;
    }


    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public int getChapter() {
        return chapter;
    }

    public void setChapter(int chapter) {
        this.chapter = chapter;
    }

    public void setRightAnswered(boolean rightAnswered) {
        isRightAnswered = rightAnswered;
    }

    public boolean isBookingEntry() {
        return isBookingEntry;
    }

    public void setBookingEntry(boolean bookingEntry) {
        isBookingEntry = bookingEntry;
    }

    public int getFromPage() {
        return fromPage;
    }

    public void setFromPage(int fromPage) {
        this.fromPage = fromPage;
    }

    public int getToPage() {
        return toPage;
    }

    public void setToPage(int toPage) {
        this.toPage = toPage;
    }

}

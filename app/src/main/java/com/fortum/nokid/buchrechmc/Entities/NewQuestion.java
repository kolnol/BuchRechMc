package com.fortum.nokid.buchrechmc.Entities;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by Nokid on 19/10/2016.
 */

public class NewQuestion extends RealmObject {
    private long id;
    private String content;
    private RealmList<NewAnswer> possibleAnswers;

    private int correctAnswerId;
    private int chapter;
    private String hint;
    private boolean isRightAnswered;
    private boolean isBookingEntry;
    private int fromPage;
    private int toPage;

    public NewQuestion() {
    }

    public NewQuestion(long id, String content, RealmList<NewAnswer> possibleAnswers, int correctAnswerId, int chapter, String hint, boolean isRightAnswered, boolean isBookingEntry, int fromPage, int toPage) {
        this.id = id;
        this.content = content;
        this.possibleAnswers = possibleAnswers;
        this.correctAnswerId = correctAnswerId;
        this.chapter = chapter;
        this.hint = hint;
        this.isRightAnswered = isRightAnswered;
        this.isBookingEntry = isBookingEntry;
        this.fromPage = fromPage;
        this.toPage = toPage;
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

    public RealmList<NewAnswer> getPossibleAnswers() {
        return possibleAnswers;
    }

    public void setPossibleAnswers(RealmList<NewAnswer> possibleAnswers) {
        this.possibleAnswers = possibleAnswers;
    }

    public int getCorrectAnswerId() {
        return correctAnswerId;
    }

    public void setCorrectAnswerId(int correctAnswerId) {
        this.correctAnswerId = correctAnswerId;
    }

    public int getChapter() {
        return chapter;
    }

    public void setChapter(int chapter) {
        this.chapter = chapter;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public boolean isRightAnswered() {
        return isRightAnswered;
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

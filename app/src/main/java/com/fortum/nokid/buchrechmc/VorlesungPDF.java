package com.fortum.nokid.buchrechmc;

import io.realm.RealmList;
import io.realm.RealmObject;

public class VorlesungPDF extends RealmObject{
    private int id;
    private String name;
    private RealmList<IntegerRealm> questionsPageNumbers;
    private RealmList<Page> pages;


    public VorlesungPDF() {
    }

    public VorlesungPDF(int id, String name, RealmList<IntegerRealm> questionsPageNumbers, RealmList<Page> pages) {
        this.id = id;
        this.name = name;
        this.questionsPageNumbers = questionsPageNumbers;
        this.pages = pages;
    }

    public String getName() {
        return name;
    }

    public RealmList<IntegerRealm> getQuestionsPageNumbers() {
        return questionsPageNumbers;
    }

    public RealmList<Page> getPages() {
        return pages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuestionsPageNumbers(RealmList<IntegerRealm> questionsPageNumbers) {
        this.questionsPageNumbers = questionsPageNumbers;
    }

    public void setPages(RealmList<Page> pages) {
        this.pages = pages;
    }
}

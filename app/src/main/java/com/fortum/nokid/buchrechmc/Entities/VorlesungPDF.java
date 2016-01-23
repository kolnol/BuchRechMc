package com.fortum.nokid.buchrechmc.Entities;

import com.fortum.nokid.buchrechmc.Entities.Page;
import com.fortum.nokid.buchrechmc.RealmClasses.RealmInteger;

import io.realm.RealmList;
import io.realm.RealmObject;

public class VorlesungPDF extends RealmObject{
    private int id;
    private String name;
    private RealmList<RealmInteger> questionsPageNumbers;
    private RealmList<Page> pages;


    public VorlesungPDF() {
    }

    public VorlesungPDF(int id, String name, RealmList<RealmInteger> questionsPageNumbers, RealmList<Page> pages) {
        this.id = id;
        this.name = name;
        this.questionsPageNumbers = questionsPageNumbers;
        this.pages = pages;
    }

    public String getName() {
        return name;
    }

    public RealmList<RealmInteger> getQuestionsPageNumbers() {
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

    public void setQuestionsPageNumbers(RealmList<RealmInteger> questionsPageNumbers) {
        this.questionsPageNumbers = questionsPageNumbers;
    }

    public void setPages(RealmList<Page> pages) {
        this.pages = pages;
    }
}

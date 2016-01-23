package com.fortum.nokid.buchrechmc.Entities;

import io.realm.RealmList;
import io.realm.RealmObject;


public class Exercise extends RealmObject{
    private String aufgabeText;
    private String beleg;
    private RealmList<Konto> rightSoll;
    private RealmList<Konto> rightHaben;
    private RealmList<Konto> falseSollOderHaben;

    public Exercise() {
    }

    public Exercise(String aufgabeText,String beleg, RealmList<Konto> rightSoll, RealmList<Konto> rightHaben, RealmList<Konto> falseSollOderHaben) {
        this.aufgabeText = aufgabeText;
        this.beleg = beleg;
        this.rightSoll = rightSoll;
        this.rightHaben = rightHaben;
        this.falseSollOderHaben = falseSollOderHaben;
    }

    public String getBeleg() {
        return beleg;
    }

    public void setBeleg(String beleg) {
        this.beleg = beleg;
    }

    public String getAufgabeText() {
        return aufgabeText;
    }

    public void setAufgabeText(String aufgabeText) {
        this.aufgabeText = aufgabeText;
    }

    public RealmList<Konto> getRightSoll() {
        return rightSoll;
    }

    public void setRightSoll(RealmList<Konto> rightSoll) {
        this.rightSoll = rightSoll;
    }

    public RealmList<Konto> getRightHaben() {
        return rightHaben;
    }

    public void setRightHaben(RealmList<Konto> rightHaben) {
        this.rightHaben = rightHaben;
    }

    public RealmList<Konto> getFalseSollOderHaben() {
        return falseSollOderHaben;
    }

    public void setFalseSollOderHaben(RealmList<Konto> falseSollOderHaben) {
        this.falseSollOderHaben = falseSollOderHaben;
    }
}

package com.fortum.nokid.buchrechmc.Entities;

import io.realm.RealmObject;


public class Konto extends RealmObject {
    private int kontoNr;
    private String name;
    private String art;

    public Konto(int kontoNr, String name, String art) {

        this.kontoNr = kontoNr;
        this.name = name;
        this.art = art;
    }

    public Konto() {
    }

    public int getKontoNr() {
        return kontoNr;
    }

    public void setKontoNr(int kontoNr) {
        this.kontoNr = kontoNr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArt() {
        return art;
    }

    public void setArt(String art) {
        this.art = art;
    }


}

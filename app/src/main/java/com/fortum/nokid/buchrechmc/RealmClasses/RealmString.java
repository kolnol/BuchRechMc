package com.fortum.nokid.buchrechmc.RealmClasses;

import io.realm.RealmObject;


public class RealmString extends RealmObject {
    private String string;

    public RealmString() {
    }

    public RealmString(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}

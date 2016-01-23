package com.fortum.nokid.buchrechmc.RealmClasses;


import io.realm.RealmObject;

public class RealmBoolean extends RealmObject{
    private boolean value;

    public RealmBoolean(boolean value) {
        this.value = value;
    }

    public RealmBoolean() {
    }

    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }
}

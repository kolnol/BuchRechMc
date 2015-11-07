package com.fortum.nokid.buchrechmc;

import io.realm.RealmObject;

public class Page extends RealmObject{
    private int from;
    private int to;

    public Page() {
    }

    public Page(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public int getTo() {
        return to;
    }
}

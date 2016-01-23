package com.fortum.nokid.buchrechmc.RealmClasses;

import io.realm.RealmObject;

/**
 * Created by Nokid on 07/11/15.
 */
public class RealmInteger extends RealmObject {
    private Integer integer;

    public RealmInteger() {
    }

    public RealmInteger(Integer integer) {
        this.integer = integer;
    }

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }

}

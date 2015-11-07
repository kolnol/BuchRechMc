package com.fortum.nokid.buchrechmc;

import io.realm.RealmObject;

/**
 * Created by Nokid on 07/11/15.
 */
public class IntegerRealm extends RealmObject {
    private Integer integer;

    public IntegerRealm() {
    }

    public IntegerRealm(Integer integer) {
        this.integer = integer;
    }

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }

}

package com.fortum.nokid.buchrechmc.Entities;

import io.realm.RealmCollection;
import io.realm.RealmList;
import io.realm.RealmObject;

public class User extends RealmObject{

    private int id;

    private String lastName;

    private String firstName;

    private String password;

    private String email;

    private String role;

    private String token;

    private RealmList<UserQuestion> answeredQuestions;

    public User() { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public RealmList<UserQuestion> getAnsweredQuestions() {
        return answeredQuestions;
    }

    public void setAnsweredQuestions(RealmList<UserQuestion> answeredQuestions) {
        this.answeredQuestions = answeredQuestions;
    }


}
package com.fortum.nokid.buchrechmc.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.realm.RealmCollection;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class User extends RealmObject{
    @JsonIgnore
    @PrimaryKey
    private int id;

    private String lastName;

    private String firstName;

    private String password;

    private String email;

    private String role;

    private String token;

    @JsonIgnore
    private RealmList<UserQuestion> answeredQuestions;

    private String sessionId;

    public User() { }



    public User(String password, String email, String sessionId) {

        this.password = password;
        this.email = email;
        this.sessionId = sessionId;
    }

    public User(String lastName, String firstName, String password, String email){
        this.lastName = lastName;
        this.firstName = firstName;
        this.password = password;
        this.email = email;
    }
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

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
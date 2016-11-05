package com.fortum.nokid.buchrechmc.Entities;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by Nokid on 19/10/2016.
 */

public class NewUser extends RealmObject{

    private int id;

    private String lastName;

    private String firstName;

    private String password;

    private String email;

    private String role;

    private String token;

    private RealmList<NewUserQuestion> answeredQuestions;

    public NewUser() {
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

    public RealmList<NewUserQuestion> getAnsweredQuestions() {
        return answeredQuestions;
    }

    public void setAnsweredQuestions(RealmList<NewUserQuestion> answeredQuestions) {
        this.answeredQuestions = answeredQuestions;
    }

    public NewUser(int id, String lastName, String firstName, String password, String email, String role, String token, RealmList<NewUserQuestion> answeredQuestions) {

        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.password = password;
        this.email = email;
        this.role = role;
        this.token = token;
        this.answeredQuestions = answeredQuestions;
    }
}

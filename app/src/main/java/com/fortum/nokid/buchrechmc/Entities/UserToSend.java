package com.fortum.nokid.buchrechmc.Entities;

public class UserToSend {

    private String lastName;

    private String firstName;

    private String password;

    private String email;

    public UserToSend() {}

    public UserToSend(String password, String email, String sessionId) {

        this.password = password;
        this.email = email;

    }

    public UserToSend(String lastName, String firstName, String password, String email){
        this.lastName = lastName;
        this.firstName = firstName;
        this.password = password;
        this.email = email;
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

}
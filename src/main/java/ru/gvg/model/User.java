package ru.gvg.model;

import java.util.UUID;

/**
 * @author Valeriy Gyrievskikh
 * @since 05.08.2018.
 */
public class User {

    private String id = UUID.randomUUID().toString();
    private String firstName;
    private String secondName;
    private String email;

    public User() {
    }

    public User(String firstName, String secondName, String email) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

}

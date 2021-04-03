package ru.itis.myapplication.models;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Integer photo;

    public User(String firstName, String lastName, String email, String password, Integer photo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.photo = photo;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Integer getPhoto() {
        return photo;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}

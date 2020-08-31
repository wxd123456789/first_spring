package com.first_spring_demo.mbg.model;

public class User extends AbstractEntity {

    private String email;
    private String password;
    private String name;

    public User(String id, String email, String password, String name, String createAt) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.password = password;
        this.createdAt = createAt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("User(id=%s, email=%s, name=%s, password=%s, createdAt=%s)", getId(),
                getEmail(), getName(), getPassword(), getCreatedAt());
    }
}

package com.incubator.project.entity;

import java.util.Objects;

public class User {
    public static final String TABLE = "users";
    public static final String ID_COLUMN = "user_id";
    public static final String NAME_COLUMN = "name";
    public static final String SURE_NAME_COLUMN = "sure_name";

    private Integer id;
    private String name;
    private String sureName;

    public User(Integer id, String name, String sureName) {
        this.id = id;
        this.name = name;
        this.sureName = sureName;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSureName(String sureName) {
        this.sureName = sureName;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSureName() {
        return sureName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) &&
                name.equals(user.name) &&
                sureName.equals(user.sureName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, sureName);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sureName='" + sureName + '\'' +
                '}';
    }
}

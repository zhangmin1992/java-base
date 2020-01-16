package com.my.java.util.FSTSeriazle;

import lombok.Data;

import java.io.Serializable;

@Data
public class MUser implements Serializable {

    private String username;
    private int age;
    private String password;

    public String getUsername() {
        return username;
    }

    public int getAge() {
        return age;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
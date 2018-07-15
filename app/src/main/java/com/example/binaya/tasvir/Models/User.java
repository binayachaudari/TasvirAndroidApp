package com.example.binaya.tasvir.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Binaya on 7/15/18.
 */

public class User implements Serializable{

    private String name;
    private String username;
    private String email;
    private String avatar;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUserame(String userame) {
        this.username = userame;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}

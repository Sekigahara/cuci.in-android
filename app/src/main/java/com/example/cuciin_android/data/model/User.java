package com.example.cuciin_android.data.model;


import android.text.TextUtils;

public class User {
    private int id;
    private String full_name;
    private String username;
    private String password;
    private String phone;
    private String email;

    public User(int id, String full_name, String username, String password, String phone, String email){
        this.id = id;
        this.full_name = full_name;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
    }

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return full_name;
    }

    public void setFullName(String full_name) {
        this.full_name = full_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int isValidData(){
        if(TextUtils.isEmpty(getUsername()))
            return 0;
        else if(getPassword().length() <= 6)
            return 1;
        else
            return 2;
    }
}

package com.example.cuciin_android.data.model.login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DataLoginObj implements Serializable {

    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("id")
    @Expose
    private int id;

    public DataLoginObj(String token, int id){
        this.token = token;
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

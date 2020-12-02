package com.example.cuciin_android.data.model.user;

import android.text.TextUtils;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserObj {
    private int id;
    private String full_name;
    private String username;
    private String password;
    private String phone;
    private String email;

    public UserObj(){

    }

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("data")
    @Expose
    private DataUserObj data;
    @SerializedName("message")
    @Expose
    private String message;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public DataUserObj getData() {
        return data;
    }

    public void setData(DataUserObj data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

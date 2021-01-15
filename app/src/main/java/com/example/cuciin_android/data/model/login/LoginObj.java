package com.example.cuciin_android.data.model.login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class LoginObj implements Serializable{

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("data")
    @Expose
    private DataLoginObj data;
    @SerializedName("message")
    @Expose
    private String message;

    public LoginObj(Boolean success, DataLoginObj data, String message){
        this.success = success;
        this.data = data;
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public DataLoginObj getDataObj() {
        return data;
    }

    public void setDataObj(DataLoginObj data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

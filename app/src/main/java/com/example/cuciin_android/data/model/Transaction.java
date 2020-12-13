package com.example.cuciin_android.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Transaction implements Serializable {

    @Expose
    @SerializedName("message")
    private String message;
    @Expose
    @SerializedName("data")
    private DataTransactionObj data;
    @Expose
    @SerializedName("success")
    private boolean success;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataTransactionObj getData() {
        return data;
    }

    public void setData(DataTransactionObj data) {
        this.data = data;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}

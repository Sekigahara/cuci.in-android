package com.example.cuciin_android.data.model.register;

import com.example.cuciin_android.data.model.register.DataRegisterObj;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegisterObj {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("data")
    @Expose
    private DataRegisterObj data;
    @SerializedName("message")
    @Expose
    private String message;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public DataRegisterObj getData() {
        return data;
    }

    public void setData(DataRegisterObj data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}

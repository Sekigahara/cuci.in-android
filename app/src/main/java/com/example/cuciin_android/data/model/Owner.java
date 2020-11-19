package com.example.cuciin_android.data.model;

public class Owner extends User {
    private int owner_id;

    public Owner(){

    }

    public int getOwnerId() {
        return owner_id;
    }

    public void setOwnerId(int owner_id) {
        this.owner_id = owner_id;
    }
}

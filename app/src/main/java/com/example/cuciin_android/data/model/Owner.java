package com.example.cuciin_android.data.model;

public class Owner extends User {
    private int owner_id;

    public Owner(int id, String full_name, String username, String password, String phone, String email, int owner_id){
        super(id, full_name, username, password, phone, email);
        this.owner_id = owner_id;
    }

    public int getOwnerId() {
        return owner_id;
    }

    public void setOwnerId(int owner_id) {
        this.owner_id = owner_id;
    }
}

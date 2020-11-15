package com.example.cuciin_android.data.model;

public class Customer extends User {
    private int customer_id;
    private String address;

    public Customer(){

    }

    public int getCustomerId() {
        return customer_id;
    }

    public void setCustomerId(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

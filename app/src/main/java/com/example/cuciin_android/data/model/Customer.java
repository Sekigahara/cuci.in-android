package com.example.cuciin_android.data.model;

public class Customer extends User {
    private int customer_id;
    private String address;

    public Customer(int id, String full_name, String username, String password, String phone, String email, int customer_id, String address){
        super(id, full_name, username, password, phone, email);
        this.customer_id = customer_id;
        this.address = address;
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

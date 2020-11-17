package com.example.cuciin_android.data.model;

public class Invoice {
    private String po_number;
    private String address;
    private String status;
    private float price;
    private float amount;

    public Invoice(String po_number, String address, String status, float price, float amount){
        this.po_number = po_number;
        this.address = address;
        this.status = status;
        this.price = price;
        this.amount = amount;
    }

    public String getPo_number() {
        return po_number;
    }

    public void setPo_number(String po_number) {
        this.po_number = po_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

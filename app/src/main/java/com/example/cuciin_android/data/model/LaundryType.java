package com.example.cuciin_android.data.model;

public class LaundryType {
    private String name;
    private String deskripsi;
    private String price;

    public LaundryType(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public String getDeskripsi() {
        return deskripsi;
    }
}

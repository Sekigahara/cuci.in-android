package com.example.cuciin_android.data.model;

import java.util.ArrayList;

public class Outlet {
    private int id;
    private String name;
    private String address;
    private String phone;
    private float rating;
    private ArrayList<Integer> manhoursList;
    private ArrayList<LaundryType> laundryTypeList;

    public Outlet(){
        manhoursList = new ArrayList<>();
        laundryTypeList = new ArrayList<>();
    }

    public void addManhours(Integer manhour){
        manhoursList.add(manhour);
    }

    public void addLaundryType(LaundryType laundry_type){
        laundryTypeList.add(laundry_type);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public ArrayList<Integer> getManhoursList() {
        return manhoursList;
    }

    public void setManhoursList(ArrayList<Integer> manhoursList) {
        this.manhoursList = manhoursList;
    }

    public ArrayList<LaundryType> getLaundryTypeList() {
        return laundryTypeList;
    }

    public void setLaundryTypeList(ArrayList<LaundryType> laundryTypeList) {
        this.laundryTypeList = laundryTypeList;
    }
}

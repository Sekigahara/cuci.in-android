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
    private List<Data> data;
    @Expose
    @SerializedName("success")
    private boolean success;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public static class Data {
        @Expose
        @SerializedName("outlet")
        private Outlet outlet;
        @Expose
        @SerializedName("updated_at")
        private String updated_at;
        @Expose
        @SerializedName("created_at")
        private String created_at;
        @Expose
        @SerializedName("outlet_id")
        private int outlet_id;
        @Expose
        @SerializedName("customer_id")
        private int customer_id;
        @Expose
        @SerializedName("status")
        private String status;
        @Expose
        @SerializedName("laundry_type")
        private String laundry_type;
        @Expose
        @SerializedName("amount")
        private int amount;
        @Expose
        @SerializedName("price")
        private int price;
        @Expose
        @SerializedName("address")
        private String address;
        @Expose
        @SerializedName("po_number")
        private String po_number;
        @Expose
        @SerializedName("id")
        private int id;

        public Outlet getOutlet() {
            return outlet;
        }

        public void setOutlet(Outlet outlet) {
            this.outlet = outlet;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public int getOutlet_id() {
            return outlet_id;
        }

        public void setOutlet_id(int outlet_id) {
            this.outlet_id = outlet_id;
        }

        public int getCustomer_id() {
            return customer_id;
        }

        public void setCustomer_id(int customer_id) {
            this.customer_id = customer_id;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getLaundry_type() {
            return laundry_type;
        }

        public void setLaundry_type(String laundry_type) {
            this.laundry_type = laundry_type;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPo_number() {
            return po_number;
        }

        public void setPo_number(String po_number) {
            this.po_number = po_number;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

    public static class Outlet {
        @Expose
        @SerializedName("updated_at")
        private String updated_at;
        @Expose
        @SerializedName("created_at")
        private String created_at;
        @Expose
        @SerializedName("owner_id")
        private int owner_id;
        @Expose
        @SerializedName("manhours")
        private String manhours;
        @Expose
        @SerializedName("laundry_type")
        private String laundry_type;
        @Expose
        @SerializedName("rating")
        private int rating;
        @Expose
        @SerializedName("phone")
        private String phone;
        @Expose
        @SerializedName("address")
        private String address;
        @Expose
        @SerializedName("name")
        private String name;
        @Expose
        @SerializedName("id")
        private int id;

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public int getOwner_id() {
            return owner_id;
        }

        public void setOwner_id(int owner_id) {
            this.owner_id = owner_id;
        }

        public String getManhours() {
            return manhours;
        }

        public void setManhours(String manhours) {
            this.manhours = manhours;
        }

        public String getLaundry_type() {
            return laundry_type;
        }

        public void setLaundry_type(String laundry_type) {
            this.laundry_type = laundry_type;
        }

        public int getRating() {
            return rating;
        }

        public void setRating(int rating) {
            this.rating = rating;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}

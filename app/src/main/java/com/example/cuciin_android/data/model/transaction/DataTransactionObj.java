package com.example.cuciin_android.data.model.transaction;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DataTransactionObj implements Serializable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("po_number")
    @Expose
    private String poNumber;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("price")
    @Expose
    private Double price;
    @SerializedName("amount")
    @Expose
    private Integer amount;
    @SerializedName("laundry_type")
    @Expose
    private String laundryType;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("customer_id")
    @Expose
    private Integer customerId;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("deleted_at")
    @Expose
    private Object deletedAt;
    @SerializedName("outlet_id")
    @Expose
    private Object outletId;
    @SerializedName("outlet_google_id")
    @Expose
    private String outletGoogleId;
    @SerializedName("customer")
    @Expose
    private Object customer;
    @SerializedName("outlet")
    @Expose
    private OutletTransactionObj outlet;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getLaundryType() {
        return laundryType;
    }

    public void setLaundryType(String laundryType) {
        this.laundryType = laundryType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Object getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Object deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Object getOutletId() {
        return outletId;
    }

    public void setOutletId(Object outletId) {
        this.outletId = outletId;
    }

    public String getOutletGoogleId() {
        return outletGoogleId;
    }

    public void setOutletGoogleId(String outletGoogleId) {
        this.outletGoogleId = outletGoogleId;
    }

    public Object getCustomer() {
        return customer;
    }

    public void setCustomer(Object customer) {
        this.customer = customer;
    }

    public OutletTransactionObj getOutlet() {
        return outlet;
    }

    public void setOutlet(OutletTransactionObj outlet) {
        this.outlet = outlet;
    }
}

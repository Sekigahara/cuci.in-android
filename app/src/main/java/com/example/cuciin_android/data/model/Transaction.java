package com.example.cuciin_android.data.model;

public class Transaction {
    private int id;
    private int customer_id;
    private int outlet_id;
    private Invoice invoice;
    private LaundryType laundryType;

    public Transaction(int id, int customer_id, int outlet_id, Invoice invoice, LaundryType laundryType){
        this.id = id;
        this.customer_id = customer_id;
        this.outlet_id = outlet_id;
        this.invoice = invoice;
        this.laundryType = laundryType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setInvoice(Invoice invoice){
        this.invoice = invoice;
    }

    public Invoice getInvoice(){
        return invoice;
    }

    public LaundryType getLaundryType() {
        return laundryType;
    }

    public void setLaundryType(LaundryType laundry_type) {
        this.laundryType = laundry_type;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getOutlet_id() {
        return outlet_id;
    }

    public void setOutlet_id(int outlet_id) {
        this.outlet_id = outlet_id;
    }
}

package com.example.cuciin_android.activity.modul.invoice;

import com.example.cuciin_android.data.model.Outlet;
import com.example.cuciin_android.data.model.Transaction;

import java.util.ArrayList;

public class InvoicePresenter implements InvoiceContract.Presenter{
    private final InvoiceContract.View view;

    public InvoicePresenter(InvoiceContract.View view){
        this.view = view;
    }

    public void start(){

    }

    public ArrayList<Transaction> getDataset(){
        ArrayList<Transaction> data = new ArrayList<>();

        return data;
    }
}

package com.example.cuciin_android.activity.modul.orderList;

import com.example.cuciin_android.data.model.Outlet;
import com.example.cuciin_android.data.model.Transaction;

import java.util.ArrayList;

public class OrderListPresenter implements OrderListContract.Presenter{
    private final OrderListContract.View view;

    public OrderListPresenter(OrderListContract.View view){
        this.view = view;
    }

    public void start(){

    }

    public ArrayList<Transaction> getDataset(){
        ArrayList<Transaction> data = new ArrayList<>();

        return data;
    }
}

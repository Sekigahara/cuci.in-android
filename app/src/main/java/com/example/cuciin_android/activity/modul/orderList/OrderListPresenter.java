package com.example.cuciin_android.activity.modul.orderList;

import java.util.ArrayList;

public class OrderListPresenter implements OrderListContract.Presenter{
    private final OrderListContract.View view;

    public OrderListPresenter(OrderListContract.View view){
        this.view = view;
    }

    public void start(){
    }
}

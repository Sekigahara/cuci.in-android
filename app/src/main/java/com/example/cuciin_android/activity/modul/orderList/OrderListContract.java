package com.example.cuciin_android.activity.modul.orderList;

import com.example.cuciin_android.base.BasePresenter;
import com.example.cuciin_android.base.BaseView;
import com.example.cuciin_android.data.model.Outlet;
import com.example.cuciin_android.data.model.Transaction;

import java.util.ArrayList;

public interface OrderListContract {
    interface View extends BaseView<Presenter> {
        void gotoNewTask();
    }

    interface Presenter extends BasePresenter {
        ArrayList<Transaction> getDataset();
    }
}

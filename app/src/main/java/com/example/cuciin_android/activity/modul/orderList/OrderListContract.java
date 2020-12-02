package com.example.cuciin_android.activity.modul.orderList;

import android.app.Activity;
import android.content.Intent;

import com.example.cuciin_android.base.BasePresenter;
import com.example.cuciin_android.base.BaseView;
import com.example.cuciin_android.data.model.customer.CustomerObj;
import com.example.cuciin_android.data.model.transaction.DataTransactionObj;
import com.example.cuciin_android.data.model.transaction.TransactionObj;

import java.util.ArrayList;

public interface OrderListContract {
    interface View extends BaseView<Presenter> {
        void gotoNewTask(Intent intent);
        void gotoNewTask(Intent intent, DataTransactionObj data);
        void setViewData(TransactionObj transactionObj);
    }

    interface Presenter extends BasePresenter {
        void getTransaction(Activity activity);
    }
}

package com.example.cuciin_android.activity.modul.orderList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.example.cuciin_android.base.BasePresenter;
import com.example.cuciin_android.base.BaseView;
import com.example.cuciin_android.data.model.customer.CustomerObj;
import com.example.cuciin_android.data.model.transaction.DataTransactionObj;
import com.example.cuciin_android.data.model.transaction.PackedTransaction;
import com.example.cuciin_android.data.model.transaction.TransactionObj;
import com.google.android.libraries.places.api.model.Place;

import java.lang.reflect.Array;
import java.util.ArrayList;

public interface OrderListContract {
    interface View extends BaseView<Presenter> {
        void gotoNewTask(Intent intent);
        void gotoNewTask(Intent intent, PackedTransaction packedTransaction);
        void setViewData(TransactionObj transactionObj);
        void setPackData(ArrayList<Place> listPlace);
        Activity getActivityView();
    }

    interface Presenter extends BasePresenter {
        void getTransaction(Activity activity, final Context context);
        void getDetailsGoogleOutlet(TransactionObj transactionObj, Activity activity);
        ArrayList<PackedTransaction> packTransactionData(TransactionObj transactionObj, ArrayList<Place> listGoogle);
    }
}

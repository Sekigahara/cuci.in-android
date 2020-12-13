package com.example.cuciin_android.activity.modul.order;

import android.app.Activity;
import android.content.Intent;

import com.example.cuciin_android.base.BasePresenter;
import com.example.cuciin_android.base.BaseView;
import com.example.cuciin_android.data.model.DataLaundryType;
import com.example.cuciin_android.data.model.LaundryType;
import com.example.cuciin_android.data.model.outlet.DataOutletObj;

import java.util.List;

public interface OrderContract {
    interface View extends BaseView<OrderContract.Presenter> {
        void setDataOutlet();
        void setDataTipeLaundry();
        void goToNewTask(Intent intent);
    }

    interface Presenter extends BasePresenter {
        int[] setData(int length);
        void addTransaction(Activity activity, DataOutletObj outletObj, int[] amount, LaundryType laundryType);
        int hitungHarga(double[] amount, double[] price);
        //ArrayList<LaundryType> getDataLaundryType(JsonArray laundryType);
    }
}

package com.example.cuciin_android.activity.modul.order;

import android.app.Activity;
import android.content.Intent;

import com.example.cuciin_android.base.BasePresenter;
import com.example.cuciin_android.base.BaseView;
import com.example.cuciin_android.data.model.DataLaundryType;
import com.example.cuciin_android.data.model.LaundryType;
import com.example.cuciin_android.data.model.nearby.PackedOutlet;
import com.example.cuciin_android.data.model.outlet.DataOutletObj;

import java.util.List;

public interface OrderContract {
    interface View extends BaseView<OrderContract.Presenter> {
        void setDataOutlet();
        void setDataTipeLaundry();
        void goToNewTask(Intent intent);
        void viewLaundryTypeData(LaundryType laundryType);
    }

    interface Presenter extends BasePresenter {
        int[] setData(int length);
        void addTransaction(Activity activity, PackedOutlet packedOutlet, int[] amount, LaundryType laundryType);
        public void orderItem(final Activity activity);
        public String getUrlLoad(String reference, int width, int height);
        //ArrayList<LaundryType> getDataLaundryType(JsonArray laundryType);
    }
}

package com.example.cuciin_android.activity.modul.order;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.example.cuciin_android.base.BasePresenter;
import com.example.cuciin_android.base.BaseView;
import com.example.cuciin_android.data.model.LaundryType;
import com.example.cuciin_android.data.model.PackedOutlet;

public interface OrderContract {
    interface View extends BaseView<OrderContract.Presenter> {
        void setDataOutlet();
        void setDataTipeLaundry();
        void goToNewTask(Intent intent);
        void viewLaundryTypeData(LaundryType laundryType);
    }

    interface Presenter extends BasePresenter {
        int[] setData(int length);
        void addTransaction(Activity activity, Context context, PackedOutlet packedOutlet, int[] amount, LaundryType laundryType);
        public void orderItem(final Activity activity, Context context);
        public String getUrlLoad(String reference, int width, int height);
        String settingGmapsRedirectURL(Double latitude, Double longitude, String name);
        //ArrayList<LaundryType> getDataLaundryType(JsonArray laundryType);
    }
}

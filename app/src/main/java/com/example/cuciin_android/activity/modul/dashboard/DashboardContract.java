package com.example.cuciin_android.activity.modul.dashboard;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.example.cuciin_android.base.BasePresenter;
import com.example.cuciin_android.base.BaseView;
import com.example.cuciin_android.data.model.login.LoginObj;

public interface DashboardContract {
    interface View extends BaseView<Presenter> {
        void gotoNewTask(Intent intent);
    }

    interface Presenter extends BasePresenter {
//        void getOutletData(Activity activity, LoginObj loginObj);
//        void getOutletData(Activity activity, Context context);
        void fetchMaps(int radius, String sensor, String types, Double lat, Double lng, String key, final Activity activity);
    }
}

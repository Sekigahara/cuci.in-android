package com.example.cuciin_android.activity.modul.splash;

import android.content.Intent;

import com.example.cuciin_android.base.BasePresenter;
import com.example.cuciin_android.base.BaseView;

public interface SplashContract {
    interface View extends BaseView<Presenter> {
        void gotoNewTask(Intent intent);
    }

    interface Presenter extends BasePresenter {
//        void getOutletData(Activity activity, LoginObj loginObj);
//        void getOutletData(Activity activity, Context context);
//        void fetchMaps(int radius, String sensor, String types, Double lat, Double lng, String key, final Activity activity);

    }
}

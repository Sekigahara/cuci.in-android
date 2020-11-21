package com.example.cuciin_android.activity.modul.nearby;

import android.content.Intent;

import com.example.cuciin_android.base.BasePresenter;
import com.example.cuciin_android.base.BaseView;
import com.example.cuciin_android.data.model.LoginObj;

public interface NearbyContract {
    interface View extends BaseView<Presenter> {
        void gotoNewTask(Intent intent);
        void gotoNewTask(Intent intent, LoginObj loginObj);
    }

    interface Presenter extends BasePresenter {
        String getGoogleQueryLink(String location, String radius, String API_KEY);
    }
}

package com.example.cuciin_android.activity.modul.landing;

import android.content.Intent;

import com.example.cuciin_android.base.BasePresenter;
import com.example.cuciin_android.base.BaseView;

public interface LandingContract {
    interface View extends BaseView<Presenter> {
        void gotoNewTask(Intent intent);
    }

    interface Presenter extends BasePresenter {

    }
}

package com.example.cuciin_android.activity.modul.login;

import android.app.Activity;
import android.content.Intent;

import com.example.cuciin_android.base.BasePresenter;
import com.example.cuciin_android.base.BaseView;
import com.example.cuciin_android.data.model.User;

public interface LoginContract {
    interface View extends BaseView<Presenter> {
        void gotoNewTask(Intent intent);
        void setBtnLoginOnClick(User user);
        void gotoDashboard();
    }

    interface Presenter extends BasePresenter {
        int onLogin(User user);
        void validateLogin(User user, Activity activity);
    }
}

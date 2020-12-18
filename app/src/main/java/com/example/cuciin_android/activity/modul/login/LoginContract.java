package com.example.cuciin_android.activity.modul.login;

import android.app.Activity;
import android.content.Intent;

import com.example.cuciin_android.base.BasePresenter;
import com.example.cuciin_android.base.BaseView;
import com.example.cuciin_android.data.model.User;
import com.example.cuciin_android.data.model.login.LoginObj;
import com.example.cuciin_android.data.model.user.UserObj;

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

package com.example.cuciin_android.activity.modul.register;

import android.app.Activity;
import android.content.Intent;

import com.example.cuciin_android.base.BasePresenter;
import com.example.cuciin_android.base.BaseView;

public interface RegisterContract {
    interface View extends BaseView<Presenter> {
        void gotoNewTask(Intent intent);
        void onRegisterButtonClick(String full_name, String username, String email, String phone, String password, String confirm);
    }

    interface Presenter extends BasePresenter {
        String onRegister(String full_name, String username, String email, String phone, String password, String confirm);
        void validateRegister(Activity activity, String full_name, String username, String email, String phone, String password, String confirm);
    }
}

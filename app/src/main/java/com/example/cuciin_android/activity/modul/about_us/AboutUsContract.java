package com.example.cuciin_android.activity.modul.about_us;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;

import com.example.cuciin_android.base.BasePresenter;
import com.example.cuciin_android.base.BaseView;
import com.example.cuciin_android.data.model.login.LoginObj;

public interface AboutUsContract {
    interface View extends BaseView<Presenter> {
        void gotoNewTask(Intent intent);
    }

    interface Presenter extends BasePresenter {
        Bitmap compressImages(Context context, int resource, int width, int height);
    }
}

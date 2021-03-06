package com.example.cuciin_android.activity.modul.splash;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

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
        Bitmap compressImages(Context context, int resource, int width, int height);
    }
}

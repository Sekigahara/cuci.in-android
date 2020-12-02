package com.example.cuciin_android.activity.modul.nearby;

import android.app.Activity;
import android.content.Intent;

import com.example.cuciin_android.base.BasePresenter;
import com.example.cuciin_android.base.BaseView;
import com.example.cuciin_android.data.model.login.LoginObj;
import com.example.cuciin_android.data.model.outlet.DataOutletObj;
import com.example.cuciin_android.data.model.outlet.OutletObj;

import java.util.List;

public interface NearbyContract {
    interface View extends BaseView<Presenter> {
        void gotoNewTask(Intent intent);
        void gotoNewTask(Intent intent, LoginObj loginObj);
        void viewNearby(OutletObj outletObj);
    }

    interface Presenter extends BasePresenter {
        List<DataOutletObj> sortByAscending(List<DataOutletObj> data);
        void fetchMaps(int radius, String sensor, String types, Double lat, Double lng, String key, final Activity activity);
    }
}

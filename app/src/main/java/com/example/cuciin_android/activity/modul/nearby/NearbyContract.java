package com.example.cuciin_android.activity.modul.nearby;

import android.app.Activity;
import android.content.Intent;

import com.example.cuciin_android.base.BasePresenter;
import com.example.cuciin_android.base.BaseView;
import com.example.cuciin_android.data.model.login.LoginObj;
import com.example.cuciin_android.data.model.outlet.DataOutletObj;

import java.util.List;

public interface NearbyContract {
    interface View extends BaseView<Presenter> {
        void gotoNewTask(Intent intent);
        void gotoNewTask(Intent intent, LoginObj loginObj);
    }

    interface Presenter extends BasePresenter {
        List<DataOutletObj> sortByAscending(List<DataOutletObj> data);
    }
}

package com.example.cuciin_android.activity.modul.landing;

import com.example.cuciin_android.base.BasePresenter;
import com.example.cuciin_android.base.BaseView;
import com.example.cuciin_android.data.model.Outlet;

import java.util.ArrayList;

public interface LandingContract {
    interface View extends BaseView<Presenter> {
        void gotoNewTask();
    }

    interface Presenter extends BasePresenter {

    }
}

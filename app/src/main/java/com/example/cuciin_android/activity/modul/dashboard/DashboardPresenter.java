package com.example.cuciin_android.activity.modul.dashboard;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.cuciin_android.activity.modul.nearby.NearbyActivity;
import com.example.cuciin_android.data.model.login.LoginObj;
import com.example.cuciin_android.data.model.OutletTestObj;
import com.example.cuciin_android.data.model.outlet.OutletObj;
import com.example.cuciin_android.utils.utility.UtilProvider;
import com.example.cuciin_android.helper.ApiGoogleService;
import com.example.cuciin_android.helper.ApiService;
import com.example.cuciin_android.helper.UtilsApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardPresenter implements DashboardContract.Presenter{
    private final DashboardContract.View view;

    public DashboardPresenter(DashboardContract.View view){
        this.view = view;
    }

    public void start(){

    }
}
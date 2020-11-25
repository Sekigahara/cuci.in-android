package com.example.cuciin_android.activity.modul.dashboard;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.cuciin_android.activity.modul.nearby.NearbyActivity;
import com.example.cuciin_android.data.model.login.LoginObj;
import com.example.cuciin_android.data.model.OutletTestObj;
import com.example.cuciin_android.data.model.outlet.Location;
import com.example.cuciin_android.data.model.outlet.OutletObj;
import com.example.cuciin_android.data.source.util.UtilProvider;
import com.example.cuciin_android.helper.ApiGoogleService;
import com.example.cuciin_android.helper.ApiService;
import com.example.cuciin_android.helper.UtilsApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardPresenter implements DashboardContract.Presenter{
    private final DashboardContract.View view;
    ApiService mApiService;
    ApiGoogleService mGoogleApiService;

    public DashboardPresenter(DashboardContract.View view){
        this.view = view;
    }

    public void start(){

    }

    public void fetchMaps(int radius, String sensor ,String types, final Double lat, final Double lng, String key, final Activity activity) {
        String location = lat.toString() + ", " + lng.toString();
        UtilProvider.initLocationSession(lat ,lng);

        mGoogleApiService = UtilsApi.getApiService();
        Call<OutletObj> call = mGoogleApiService.getNearestLaundry(types, location, radius, sensor, key);
        call.enqueue(new Callback<OutletObj>() {
            @Override
            public void onResponse(Call<OutletObj> call, Response<OutletObj> response) {
                if (response.isSuccessful() == true) {
                    OutletObj outletObj = response.body();
                    if (outletObj.getStatus().equals("OK")) {
                        Toast.makeText(activity, "Sort by Ascending", Toast.LENGTH_LONG).show();

                        Intent intent = new Intent(activity, NearbyActivity.class);
                        //intent.putExtra("session", loginObj);
                        intent.putExtra("outlet", outletObj);

                        view.gotoNewTask(intent);
                    } else
                        Toast.makeText(activity, outletObj.getStatus(), Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(activity, "Error2", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(activity, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
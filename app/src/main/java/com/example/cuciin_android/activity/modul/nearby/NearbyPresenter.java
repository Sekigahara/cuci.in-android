package com.example.cuciin_android.activity.modul.nearby;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

import com.example.cuciin_android.data.model.outlet.OutletObj;
import com.example.cuciin_android.data.source.util.UtilProvider;
import com.example.cuciin_android.helper.ApiGoogleService;
import com.example.cuciin_android.helper.ApiService;
import com.example.cuciin_android.helper.UtilsApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NearbyPresenter  implements NearbyContract.Presenter {
    private final NearbyContract.View view;
    ApiGoogleService mApiService;

    public NearbyPresenter(NearbyContract.View view){
        this.view = view;
    }

    public void start(){

    }
}

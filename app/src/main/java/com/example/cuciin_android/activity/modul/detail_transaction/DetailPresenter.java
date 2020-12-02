package com.example.cuciin_android.activity.modul.detail_transaction;

import com.example.cuciin_android.data.model.outlet.DataOutletObj;
import com.example.cuciin_android.helper.ApiGoogleService;
import com.example.cuciin_android.utils.utility.UtilProvider;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.SphericalUtil;

import java.util.List;

public class DetailPresenter implements DetailContract.Presenter {
    private final DetailContract.View view;

    public DetailPresenter(DetailContract.View view){
        this.view = view;
    }

    public void start(){

    }

}

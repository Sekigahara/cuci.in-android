package com.example.cuciin_android.activity.modul.nearby;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

import com.example.cuciin_android.data.model.outlet.DataOutletObj;
import com.example.cuciin_android.data.model.outlet.OutletObj;
import com.example.cuciin_android.helper.ApiGoogleService;
import com.example.cuciin_android.helper.UtilsApi;
import com.example.cuciin_android.utils.utility.UtilProvider;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.SphericalUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NearbyPresenter  implements NearbyContract.Presenter {
    private final NearbyContract.View view;
    ApiGoogleService mGoogleApiService;
    ApiGoogleService mApiService;

    public NearbyPresenter(NearbyContract.View view){
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

                        view.viewNearby(outletObj);
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

    public List<DataOutletObj> sortByAscending(List<DataOutletObj> data){
        int arrayLength = data.size();

        Double fromLat = UtilProvider.getLocationUtil().getLocationLatitude();
        Double fromLng = UtilProvider.getLocationUtil().getLocationLongitude();
        LatLng from = new LatLng(fromLat, fromLng);
        for(int i = 0 ; i < arrayLength - 1; i++){
            int min_idx = i;

            Double toLat = data.get(min_idx).getGeometry().getLocation().getLat();
            Double toLng = data.get(min_idx).getGeometry().getLocation().getLng();
            LatLng to = new LatLng(toLat, toLng);


            Double distance = countDistance(from, to);

            for(int k = i + 1; k < arrayLength; k++){
                Double toLat1 = data.get(k).getGeometry().getLocation().getLat();
                Double toLng1 = data.get(k).getGeometry().getLocation().getLng();
                LatLng toNext  = new LatLng(toLat1, toLng1);
                Double distanceNext = countDistance(from, toNext);

                if(distanceNext < distance)
                    min_idx = k;
            }

            DataOutletObj tempData = data.get(min_idx);
            data.set(min_idx, data.get(i));
            data.set(i, tempData);
        }

        return data;
    }

    private Double countDistance(LatLng from, LatLng to){
        return SphericalUtil.computeDistanceBetween(from ,to) / 1000;
    }
}

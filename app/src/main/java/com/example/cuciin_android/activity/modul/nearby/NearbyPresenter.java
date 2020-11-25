package com.example.cuciin_android.activity.modul.nearby;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.example.cuciin_android.activity.modul.order.OrderActivity;
import com.example.cuciin_android.data.model.LaundryType;
import com.example.cuciin_android.data.model.outlet.DataOutletObj;
import com.example.cuciin_android.data.model.outlet.DataOutletObj;
import com.example.cuciin_android.helper.ApiGoogleService;
import com.example.cuciin_android.utils.utility.UtilProvider;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.SphericalUtil;

import java.util.List;

public class NearbyPresenter  implements NearbyContract.Presenter {
    private final NearbyContract.View view;
    ApiGoogleService mApiService;
    ApiService mApiServiceLaundry;

    public NearbyPresenter(NearbyContract.View view){
        this.view = view;
    }

    public void start(){

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

    @Override
    public void orderItem(final Activity activity, final DataOutletObj outletObj) {
        mApiServiceLaundry = UtilsApi.getAPIService();
        Call<LaundryType> call = mApiServiceLaundry.getLaundryTypeAll();
        call.enqueue(new Callback<LaundryType>() {
            @Override
            public void onResponse(Call<LaundryType> call, Response<LaundryType> response) {
                try {
                    if(response.body()!=null)
                        Toast.makeText(activity," response message "+ response.body().toString(),Toast.LENGTH_LONG).show();
                    if(response.errorBody()!=null)
                        Toast.makeText(activity," response message "+response.errorBody().string(),Toast.LENGTH_LONG).show();
                }catch (Exception e){
                    e.printStackTrace();
                }
                if(response.isSuccessful() == true){
                    LaundryType laundryTypeAll = response.body();
                    if(laundryTypeAll.getSuccess() == true){
                        Intent intent = new Intent(activity, OrderActivity.class);
                        intent.putExtra("laundryType", laundryTypeAll);
                        intent.putExtra("outletObj", outletObj);

                        view.gotoNewTask(intent);
                    }else
                        Log.d("error 1", "error 1 : " + laundryTypeAll.getMessage());
                }else
                    Log.d("error 2", "error 2 : " + response.message());
            }

            @Override
            public void onFailure(Call<LaundryType> call, Throwable t) {

            }
        });
    }

//    @Override
//    public void goToOrder(final Activity activity, final LoginObj loginObj, final DataOutletTestObj dataOutletObj) {
//        mApiServiceLaundry = UtilsApi.getAPIService();
//        Call<LaundryType> call = mApiServiceLaundry.getLaundryTypeAll("Bearer " +
//                                                loginObj.getDataObj().getToken());
//        call.enqueue(new Callback<LaundryType>() {
//            @Override
//            public void onResponse(Call<LaundryType> call, Response<LaundryType> response) {
//                if(response.isSuccessful() == true){
//                    LaundryType laundryTypeAll = response.body();
//                    if(laundryTypeAll.getSuccess() == true){
//                        Intent intent = new Intent(activity, OrderActivity.class);
//                        intent.putExtra("loginObj", loginObj);
//                        intent.putExtra("dataOutletObj", dataOutletObj);
//                        intent.putExtra("laundryType", laundryTypeAll);
//
//                        view.gotoNewTask(intent);
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<LaundryType> call, Throwable t) {
//
//            }
//        });
//
//    }
}

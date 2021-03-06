package com.example.cuciin_android.activity.modul.nearby;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.widget.Toast;

import com.example.cuciin_android.data.model.PackedOutlet;
import com.example.cuciin_android.data.model.outlet.DataOutletObj;
import com.example.cuciin_android.data.model.outlet.OutletObj;
import com.example.cuciin_android.data.model.outlet_local.OutletLocal;
import com.example.cuciin_android.helper.ApiGoogleService;
import com.example.cuciin_android.helper.ApiService;
import com.example.cuciin_android.helper.UtilsApi;
import com.example.cuciin_android.utils.utility.UtilProvider;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.SphericalUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.LOCATION_SERVICE;

public class NearbyPresenter implements NearbyContract.Presenter {
    private final NearbyContract.View view;
    ApiService mApiService;
    ApiGoogleService mGoogleApiService;

    public NearbyPresenter(NearbyContract.View view){
        this.view = view;
    }

    public void start(){

    }

    public void fetchMaps(int radius, String sensor ,String types, String key, final Activity activity) {
        LocationManager mLocationManager;
        mLocationManager = (LocationManager) activity.getSystemService(LOCATION_SERVICE);
        List<String> providers = mLocationManager.getProviders(true);
        Location bestLocation = null;
        for (String provider : providers) {
            Location l = mLocationManager.getLastKnownLocation(provider);
            if (l == null) {
                continue;
            }
            if (bestLocation == null || l.getAccuracy() < bestLocation.getAccuracy()) {
                // Found best last known location: %s", l);
                bestLocation = l;
            }
        }

        Double lat = bestLocation.getLatitude();
        Double lng = bestLocation.getLongitude();

        String location = lat.toString() + ", " + lng.toString();
        UtilProvider.initLocationSession(lat ,lng);

        //Toast.makeText(activity, "lat : " + lat.toString() + " lng : " + lng.toString(), Toast.LENGTH_LONG).show();
        mGoogleApiService = UtilsApi.getGoogleApiService();
        Call<OutletObj> call = mGoogleApiService.getNearestLaundry(types, location, radius, sensor, key);
        call.enqueue(new Callback<OutletObj>() {
            @Override
            public void onResponse(Call<OutletObj> call, Response<OutletObj> response) {
                if (response.isSuccessful() == true) {
                    OutletObj outletObj = response.body();
                    if (outletObj.getStatus().equals("OK")) {
                        view.viewNearby(outletObj);
                    } else
                        Toast.makeText(activity, "error 1 : " + outletObj.getStatus(), Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(activity, "error 2 : " +response.errorBody().toString(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(activity, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void fetchLocalMaps(final List<DataOutletObj> data, final Activity activity, final String token){
        mApiService = UtilsApi.getLocalAPIService();
        //String TOKEN = UtilProvider.getUserSessionUtil().getSession().getDataObj().getToken();

        Call<OutletLocal> call = mApiService.getLocalOutlet("Bearer " + token);
        call.enqueue(new Callback<OutletLocal>() {
            @Override
            public void onResponse(Call<OutletLocal> call, Response<OutletLocal> response) {
                if (response.isSuccessful() == true) {
                    OutletLocal outletLocal = response.body();
                    if (outletLocal.getSuccess() == true) {
                        //Toast.makeText(activity, "Sort by Ascending", Toast.LENGTH_LONG).show();

                        packingData(data, outletLocal);
                    } else
                        Toast.makeText(activity, outletLocal.getMessage(), Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(activity, response.errorBody().toString(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(activity, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void packingData(final List<DataOutletObj> data, OutletLocal outletLocal){
        double random = new Random().nextDouble();
        ArrayList<PackedOutlet> listOutlet = new ArrayList<>();

        //set outlet google
        for(int i = 0 ; i < data.size(); i++){
            PackedOutlet packedOutlet = new PackedOutlet();

            //set distance
            Double fromLat = UtilProvider.getLocationUtil().getLocationLatitude();
            Double fromLng = UtilProvider.getLocationUtil().getLocationLongitude();
            LatLng from = new LatLng(fromLat, fromLng);

            Double toLat = data.get(i).getGeometry().getLocation().getLat();
            Double toLng = data.get(i).getGeometry().getLocation().getLng();
            LatLng to  = new LatLng(toLat, toLng);

            //set lng and lat
            packedOutlet.setLat(data.get(i).getGeometry().getLocation().getLat());
            packedOutlet.setLng(data.get(i).getGeometry().getLocation().getLng());

            //set distance
            packedOutlet.setDistance(countDistance(from, to));

            //set google id
            packedOutlet.setIdGoogle(data.get(i).getPlaceId());
            packedOutlet.setId(null);
            //set laundry name
            packedOutlet.setName(data.get(i).getName());

            //set open status
            if(data.get(i).getOpeningHours() == null)
                packedOutlet.setOpen(false);
            else
                packedOutlet.setOpen(data.get(i).getOpeningHours().getOpenNow());
            //set photo
            if(data.get(i).getPhotos() == null)
                packedOutlet.setPhoto(null);
            else
                packedOutlet.setPhoto(data.get(i).getPhotos().get(0).getPhotoReference());

            //set rating
            packedOutlet.setRating(data.get(i).getRating());
            listOutlet.add(packedOutlet);
        }

        //set outlet local
        for(int i = 0 ; i < outletLocal.getData().size(); i++){
            PackedOutlet packedOutlet = new PackedOutlet();

            //set distance
            packedOutlet.setDistance(0.1 + (random * (5.8 - 0.1)));
            packedOutlet.setIdGoogle(null);
            packedOutlet.setId(outletLocal.getData().get(i).getId().toString());
            packedOutlet.setName(outletLocal.getData().get(i).getName());
            packedOutlet.setOpen(true);
            packedOutlet.setPhoto(null);
            packedOutlet.setRating(outletLocal.getData().get(i).getRating().floatValue());

            listOutlet.add(packedOutlet);
        }

        view.showAllView(listOutlet);
    }

    public ArrayList<PackedOutlet> sortByAscending(ArrayList<PackedOutlet> data){
        int arrayLength = data.size();

        for(int i = 0 ; i < arrayLength ; i++){
            int min = i;

            for(int k = i + 1 ; k < arrayLength; k++){
                if(data.get(k).getDistance() < data.get(min).getDistance())
                    min = k;
            }

            PackedOutlet packedOutlet = data.get(min);
            data.set(min, data.get(i));
            data.set(i, packedOutlet);
        }

        return data;
    }

    private Double countDistance(LatLng from, LatLng to){
        return SphericalUtil.computeDistanceBetween(from ,to) / 1000;
    }
}

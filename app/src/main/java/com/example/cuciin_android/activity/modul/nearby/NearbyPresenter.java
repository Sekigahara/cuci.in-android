package com.example.cuciin_android.activity.modul.nearby;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.NetworkOnMainThreadException;
import android.util.Log;
import android.widget.Toast;

import com.example.cuciin_android.activity.modul.order.OrderActivity;
import com.example.cuciin_android.data.model.DataOutletObj;
import com.example.cuciin_android.data.model.LaundryType;
import com.example.cuciin_android.data.model.LoginObj;
import com.example.cuciin_android.data.model.OutletObj;
import com.example.cuciin_android.helper.ApiService;
import com.example.cuciin_android.helper.UtilsApi;

import org.json.JSONObject;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.io.IOException;
import org.json.JSONException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NearbyPresenter  implements NearbyContract.Presenter {
    private final NearbyContract.View view;
    ApiService mApiService;

    public NearbyPresenter(NearbyContract.View view){
        this.view = view;
    }

    public void start(){

    }

    public String getGoogleQueryLink(String location, String radius, String API_KEY) {
        return "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=" + location + "&radius=" + radius + "&type=laundry&key=" + API_KEY;
    }

    @Override
    public void orderItem(final Activity activity, final LoginObj loginObj, final DataOutletObj dataOutletObj) {
        mApiService = UtilsApi.getAPIService();
        Call<LaundryType> call = mApiService.getLaundryTypeList("Bearer " +
                                                                loginObj.getDataObj().getToken());
        call.enqueue(new Callback<LaundryType>() {
            @Override
            public void onResponse(Call<LaundryType> call, Response<LaundryType> response) {
                if(response.isSuccessful() == true){
                    LaundryType laundryType = response.body();
                    if(laundryType.getSuccess() == true){
                        Toast.makeText(activity, "get laundry type", Toast.LENGTH_LONG).show();

                        Intent intent = new Intent(activity, OrderActivity.class);
                        intent.putExtra("session", loginObj);
                        intent.putExtra("dataOutletObject", dataOutletObj);
                        intent.putExtra("laundryTypeList", laundryType);

                        view.gotoNewTask(intent);
                    }else
                        Toast.makeText(activity, "Error1", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(activity, String.valueOf(response.code()), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<LaundryType> call, Throwable t) {

            }
        });
    }
}

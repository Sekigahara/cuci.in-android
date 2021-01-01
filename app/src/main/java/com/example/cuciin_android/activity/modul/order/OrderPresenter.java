package com.example.cuciin_android.activity.modul.order;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.example.cuciin_android.activity.modul.dashboard.DashboardActivity;
import com.example.cuciin_android.data.model.LaundryType;
import com.example.cuciin_android.data.model.Transaction;
import com.example.cuciin_android.data.model.PackedOutlet;
import com.example.cuciin_android.data.model.outlet.DataOutletObj;
import com.example.cuciin_android.data.model.login.LoginObj;
import com.example.cuciin_android.data.model.outlet.OutletObj;
import com.example.cuciin_android.helper.ApiGoogleService;
import com.example.cuciin_android.helper.ApiService;
import com.example.cuciin_android.helper.UtilsApi;
import com.example.cuciin_android.utils.session.UserSessionRepositoryRepository;
import com.example.cuciin_android.utils.utility.UtilProvider;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderPresenter implements OrderContract.Presenter{
    private final OrderContract.View view;
    DataOutletObj outlet;
    ApiService mApiService;
    ApiGoogleService apigoogle;
    OutletObj outletObj;

    public OrderPresenter(OrderContract.View view) {
        this.view = view;
    }

    @Override
    public void start() {

    }

    private void setDataOutlet(DataOutletObj outletObj){
        this.outlet = outlet;
    }

    public DataOutletObj getDataOutlet() {
        Log.d("ini nama", "setDataOutlet: " + outlet.getName());
        return outlet;
    }

    @Override
    public int[] setData(int length) {
        int[] data = new int[length];

        for(int i = 0; i < length; i++)
            data[i] = 0;

        return data;
    }

    @Override
    public void addTransaction(final Activity activity, final Context context, final PackedOutlet packedOutlet, int[] amount, final LaundryType laundryType) {
        String outlet_id = null;
        String google_id = null;

        outlet_id = packedOutlet.getId();
        google_id = packedOutlet.getIdGoogle();

        LoginObj loginObj = new UserSessionRepositoryRepository(context).getDataSession();
        mApiService = UtilsApi.getLocalAPIService();
        Log.d("laundry type", String.valueOf(laundryType));
        Call<Transaction> call = mApiService.addLaundryTransaction(
                "Bearer " + loginObj.getDataObj().getToken(),
                String.valueOf(packedOutlet.getName()),
                new Gson().toJson(laundryType),
                outlet_id,
                google_id,
                "Picking Up!"
        );
        call.enqueue(new Callback<Transaction>() {
            @Override
            public void onResponse(Call<Transaction> call, Response<Transaction> response) {
                if(response.isSuccessful()){
                    Transaction transaction = response.body();
                    if(transaction != null && transaction.getSuccess()){
                        Toast.makeText(activity, "Transaction Added", Toast.LENGTH_LONG).show();

                        view.goToNewTask(new Intent(activity, DashboardActivity.class));
                    }else
                        Toast.makeText(activity, response.message(), Toast.LENGTH_LONG).show();
                }else
                    Toast.makeText(activity, "error 2" + response.errorBody(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Transaction> call, Throwable t) {
                Log.d("log failur", "message on failure", t);
            }
        });
    }

    @Override
    public void orderItem(final Activity activity, final Context context) {
        LoginObj loginObj = new UserSessionRepositoryRepository(context).getDataSession();
        mApiService = UtilsApi.getLocalAPIService();
        Call<LaundryType> call = mApiService.getLaundryTypeAll("Bearer " + loginObj.getDataObj().getToken());
        call.enqueue(new Callback<LaundryType>() {
            @Override
            public void onResponse(Call<LaundryType> call, Response<LaundryType> response) {
                if(response.isSuccessful() == true){
                    LaundryType laundryTypeAll = response.body();
                    if(laundryTypeAll.getSuccess() == true){

                        view.viewLaundryTypeData(laundryTypeAll);
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

    @Override
    public String getUrlLoad(String reference, int width, int height) {
        String URL = "https://maps.googleapis.com/maps/api/place/photo?maxwidth="+width
                +"&maxheight="+height+"&photoreference="+reference+"&key="+UtilProvider.getKey();

        return URL;
    }

    public String settingGmapsRedirectURL(Double latitude, Double longitude, String name){
        return "http://maps.google.com/maps?q=loc:" + latitude + "," + longitude +"(" + name + ")";
    }
}

package com.example.cuciin_android.activity.modul.order;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.example.cuciin_android.activity.modul.dashboard.DashboardActivity;
import com.example.cuciin_android.data.model.DataLaundryType;
import com.example.cuciin_android.data.model.LaundryType;
import com.example.cuciin_android.data.model.Transaction;
import com.example.cuciin_android.data.model.outlet.DataOutletObj;
import com.example.cuciin_android.data.model.login.LoginObj;
import com.example.cuciin_android.data.model.outlet.OutletObj;
import com.example.cuciin_android.helper.ApiGoogleService;
import com.example.cuciin_android.helper.ApiService;
import com.example.cuciin_android.helper.UtilsApi;
import com.example.cuciin_android.utils.utility.UtilProvider;
import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderPresenter implements OrderContract.Presenter{
    private final OrderContract.View view;
    DataOutletObj outlet;
    ApiService mApiService;
    ApiGoogleService apigoogle;
    final LoginObj loginObj;
    OutletObj outletObj;

    public OrderPresenter(OrderContract.View view, LoginObj loginObj) {
        this.view = view;
        this.loginObj = loginObj;
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
    public void addTransaction(final Activity activity, final DataOutletObj outletObj, int[] amount, LaundryType laundryType) {
        LoginObj loginObj = UtilProvider.getUserSessionUtil().getSession();
        mApiService = UtilsApi.getAPIServiceLocal();
//        Log.d("nama outlet", outletObj.getName());
        Toast.makeText(activity, outletObj.getName(), Toast.LENGTH_LONG);
        Call<Transaction> call = mApiService.addLundryTransaction(
                "Bearer " + loginObj.getDataObj().getToken(),
                String.valueOf(outletObj.getName()),
                5000,
                500,
                String.valueOf(1),
                "masih berjalan",
                loginObj.getDataObj().getId(),
                2
        );
        call.enqueue(new Callback<Transaction>() {
            @Override
            public void onResponse(Call<Transaction> call, Response<Transaction> response) {
                Intent intent = new Intent(activity, DashboardActivity.class);
                if(response.isSuccessful() == true){
                    Transaction transaction = response.body();
                    if(transaction.getSuccess() == true){
                        Toast.makeText(activity, "Transaction Added", Toast.LENGTH_LONG).show();
                        intent.putExtra("transaction", transaction);

                        //view.goToNewTask(intent);
                    }else
                        Toast.makeText(activity, "Error 1 :" + response.message(), Toast.LENGTH_LONG).show();
                }else
                    Toast.makeText(activity, response.message(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Transaction> call, Throwable t) {

            }
        });
    }
//
    @Override
    public int hitungHarga(double[] amount, double[] price) {
        int value = 0;

        for(int i = 0; i < amount.length; i++)
            value += amount[i] * price[i];
        return value;
    }
}

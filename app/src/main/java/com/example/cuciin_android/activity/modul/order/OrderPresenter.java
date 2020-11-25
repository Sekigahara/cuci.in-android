package com.example.cuciin_android.activity.modul.order;

import android.app.Activity;
import android.util.Log;

import com.example.cuciin_android.data.model.LaundryType;
import com.example.cuciin_android.data.model.outlet.DataOutletObj;
import com.example.cuciin_android.data.model.login.LoginObj;
import com.example.cuciin_android.data.model.outlet.OutletObj;
import com.example.cuciin_android.helper.ApiGoogleService;
import com.example.cuciin_android.helper.ApiService;

import java.util.List;

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
    public void addTransaction(final Activity activity, DataOutletObj outletObj, double[] amount, List<LaundryType> laundryType/*, LoginObj loginObj*/) {
//        mApiService = UtilsApi.getAPIService();
//        Call<Transaction> call = mApiService.loginRequest();
//        call.enqueue(new Callback<Transaction>() {
//            @Override
//            public void onResponse(Call<Transaction> call, Response<Transaction> response) {
//                Intent intent = new Intent(activity, DashboardActivity.class);
//                if(response.isSuccessful() == true){
//                    Transaction transaction = response.body();
//                    if(loginObj.getSuccess() == true){
//                        Toast.makeText(activity, "Transaction Added", Toast.LENGTH_LONG).show();
//                        UtilProvider.getUserSessionUtil().setSession(loginObj);
//                        intent.putExtra("transaction", transaction);
//
//                        view.goToNewTask(intent);
//                    }else
//                        Toast.makeText(activity, "Error 1 :" + response.message(), Toast.LENGTH_LONG).show();
//                }else
//                    Toast.makeText(activity, "error 2 :" + response.message(), Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            public void onFailure(Call<Transaction> call, Throwable t) {
//
//            }
//        });
    }

//    hitung harga total/price
//    @Override
//    public double hitungHarga() {
//        return 0;
//    }

}

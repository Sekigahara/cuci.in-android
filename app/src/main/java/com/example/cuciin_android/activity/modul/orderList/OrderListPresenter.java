package com.example.cuciin_android.activity.modul.orderList;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

import com.example.cuciin_android.data.model.customer.CustomerObj;
import com.example.cuciin_android.data.model.customer.DataCustomerObj;
import com.example.cuciin_android.data.model.login.LoginObj;
import com.example.cuciin_android.data.model.transaction.TransactionObj;
import com.example.cuciin_android.data.model.user.UserObj;
import com.example.cuciin_android.helper.ApiService;
import com.example.cuciin_android.helper.UtilsApi;
import com.example.cuciin_android.utils.utility.UtilProvider;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderListPresenter implements OrderListContract.Presenter {
    private final OrderListContract.View view;
    ApiService mApiService;

    public OrderListPresenter(OrderListContract.View view) {
        this.view = view;
    }

    public void start() {
    }

    public void getTransaction(final Activity activity) {
        String token = UtilProvider.getUserSessionUtil().getSession().getDataObj().getToken();
        int id = UtilProvider.getUserSessionUtil().getSession().getDataObj().getId();

        mApiService = UtilsApi.getAPIServiceLocal();
        Call<TransactionObj> call = mApiService.getHistoryTransaction("Bearer " + token, id);
        call.enqueue(new Callback<TransactionObj>() {
            @Override
            public void onResponse(Call<TransactionObj> call, Response<TransactionObj> response) {

            }

            @Override
            public void onFailure(Call<TransactionObj> call, Throwable t) {

            }
        });
    }
}

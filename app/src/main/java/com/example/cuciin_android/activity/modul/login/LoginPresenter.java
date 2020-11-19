package com.example.cuciin_android.activity.modul.login;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

import com.example.cuciin_android.activity.modul.dashboard.DashboardActivity;
import com.example.cuciin_android.data.model.ResObj;
import com.example.cuciin_android.data.model.User;
import com.example.cuciin_android.helper.ApiService;
import com.example.cuciin_android.helper.UtilsApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter implements LoginContract.Presenter{
    private final LoginContract.View view;
    ApiService mApiService;

    public LoginPresenter(LoginContract.View view){
        this.view = view;
    }

    public void start(){

    }

    public int onLogin(User user){
        return user.isValidData();
    }

    public void validateLogin(final User user, final Activity activity){
        mApiService = UtilsApi.getAPIService();
        Call<ResObj> call = mApiService.loginRequest(user.getUsername(), user.getPassword());
        call.enqueue(new Callback<ResObj>() {
            @Override
            public void onResponse(Call<ResObj> call, Response<ResObj> response) {
                if(response.isSuccessful() == true){
                    ResObj resObj = response.body();
                    if(resObj.getSuccess() == true){
                        Toast.makeText(activity, "Login Success", Toast.LENGTH_LONG).show();
                        String token = resObj.getDataObj().getToken();

                        Intent intent = new Intent(activity, DashboardActivity.class);
                        intent.putExtra("token", token);
                        intent.putExtra("username", user.getUsername());
                        activity.startActivity(intent);
                    }else
                        Toast.makeText(activity, "Username or Password is incorrect", Toast.LENGTH_LONG).show();
                }else
                    Toast.makeText(activity, "Username or Password is incorrect", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(activity, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
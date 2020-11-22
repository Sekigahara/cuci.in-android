package com.example.cuciin_android.activity.modul.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.cuciin_android.activity.modul.dashboard.DashboardActivity;
import com.example.cuciin_android.data.model.login.LoginObj;
import com.example.cuciin_android.data.model.User;
import com.example.cuciin_android.data.source.util.UtilProvider;
import com.example.cuciin_android.helper.ApiService;
import com.example.cuciin_android.helper.UtilsApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter implements LoginContract.Presenter{
    private final LoginContract.View view;
    private final Context context;
    ApiService mApiService;

    public LoginPresenter(LoginContract.View view, Context context){
        this.view = view;
        this.context = context;
    }

    public void start(){
        UtilProvider.initUserSession(this.context);

        if(UtilProvider.getUserSessionUtil().getSession() != null){
            view.gotoDashboard();   //jika sudah login langsung masuk dashboard
        }
    }

    public int onLogin(User user){
        return user.isValidData();
    }

    public void validateLogin(final User user, final Activity activity){
        mApiService = UtilsApi.getAPIService();
        Call<LoginObj> call = mApiService.loginRequest(user.getUsername(), user.getPassword());
        call.enqueue(new Callback<LoginObj>() {
            @Override
            public void onResponse(Call<LoginObj> call, Response<LoginObj> response) {
                if(response.isSuccessful() == true){
                    LoginObj loginObj = response.body();
                    if(loginObj.getSuccess() == true){
                        Toast.makeText(activity, "Login Success", Toast.LENGTH_LONG).show();
                        UtilProvider.getUserSessionUtil().setSession(loginObj);

                        Intent intent = new Intent(activity, DashboardActivity.class);
                        //intent.putExtra("session", loginObj);

                        view.gotoNewTask(intent);
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
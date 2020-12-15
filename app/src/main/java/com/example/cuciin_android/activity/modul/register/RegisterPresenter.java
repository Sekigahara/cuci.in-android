package com.example.cuciin_android.activity.modul.register;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;

import com.example.cuciin_android.activity.modul.login.LoginActivity;
import com.example.cuciin_android.data.model.register.RegisterObj;
import com.example.cuciin_android.helper.ApiService;
import com.example.cuciin_android.helper.UtilsApi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterPresenter implements RegisterContract.Presenter{
    private final RegisterContract.View view;
    ApiService mApiService;

    public RegisterPresenter(RegisterContract.View view){
        this.view = view;
    }

    public void start(){

    }

    public String onRegister(String full_name, String username, String email,
                           String phone, String password, String confirm){
        String message = "passed";

        if(TextUtils.isEmpty(full_name) || TextUtils.isEmpty(username) || TextUtils.isEmpty(email)
                || TextUtils.isEmpty(phone) || TextUtils.isEmpty(password) || TextUtils.isEmpty(confirm)){
            message = "Don't Leave Anything Blank!";
        }else if(!password.equals(confirm) && !TextUtils.isEmpty(confirm))
            message = "Confirmed Password Do not Match";
        else if(isEmailValid(email) == false && !TextUtils.isEmpty(email))
            message = "Email Format doesn't Match";
        else if(password.length() <= 6 && !TextUtils.isEmpty(password))
            message = "Required More than 6 Characters for Password";

        return message;
    }
    public void validateRegister(final Activity activity, String full_name, String username, String email,
                                 String phone, String password, String confirm){

        mApiService = UtilsApi.getLocalAPIService();
        Call<RegisterObj> call = mApiService.registerRequest(full_name, username, email, phone, password, confirm);
        call.enqueue(new Callback<RegisterObj>() {
            @Override
            public void onResponse(Call<RegisterObj> call, Response<RegisterObj> response) {
                /*
                try {
                    if(response.body()!=null)
                        Toast.makeText(activity," response message "+ response.body().toString(),Toast.LENGTH_LONG).show();
                    if(response.errorBody()!=null)
                        Toast.makeText(activity," response message "+response.errorBody().string(),Toast.LENGTH_LONG).show();
                }catch (Exception e){
                    e.printStackTrace();
                }
                */

                if(response.isSuccessful() == true){
                    RegisterObj registerObj = response.body();
                    if(registerObj.getSuccess() == true){
                        Toast.makeText(activity, "Register Success", Toast.LENGTH_LONG).show();

                        Intent intent = new Intent(activity, LoginActivity.class);
                        view.gotoNewTask(intent);
                    }else
                        Toast.makeText(activity, "Username or Email already Exist", Toast.LENGTH_LONG).show();
                }else
                    Toast.makeText(activity, "Sorry Error", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(activity, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public static boolean isEmailValid(String email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
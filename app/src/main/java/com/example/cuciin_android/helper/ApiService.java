package com.example.cuciin_android.helper;

import com.example.cuciin_android.data.model.ResObj;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {
    @FormUrlEncoded
    @POST("login")
    Call<ResObj> loginRequest(
                @Field("username") String username,
                @Field("password") String password
    );

    @FormUrlEncoded
    @POST("register")
    Call<ResObj> registerRequest(
                @Field("full_name") String full_name,
                @Field("username") String username,
                @Field("email") String email,
                @Field("password") String password,
                @Field("confirmation") String confirmation,
                @Field("Phone") String phone
    );
}

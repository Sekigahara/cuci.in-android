package com.example.cuciin_android.helper;

import com.example.cuciin_android.data.model.LaundryType;
import com.example.cuciin_android.data.model.OutletObj;
import com.example.cuciin_android.data.model.RegisterObj;
import com.example.cuciin_android.data.model.LoginObj;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {
    @FormUrlEncoded
    @POST("login")
    Call<LoginObj> loginRequest(
                @Field("username") String username,
                @Field("password") String password
    );

    @FormUrlEncoded
    @POST("register")
    Call<RegisterObj> registerRequest(
                @Field("full_name") String full_name,
                @Field("username") String username,
                @Field("email") String email,
                @Field("phone") String phone,
                @Field("password") String password,
                @Field("confirmation") String confirmation
    );

    @GET("outlet")
    Call<OutletObj> getOutlet(
                @Header("Authorization") String token
    );

    @GET("laundry/type")
    Call<LaundryType> getLaundryTypeList(
            @Header("Authorization") String token
    );
}

package com.example.cuciin_android.helper;

import com.example.cuciin_android.data.model.DataLaundryType;
import com.example.cuciin_android.data.model.LaundryType;
import com.example.cuciin_android.data.model.OutletTestObj;
import com.example.cuciin_android.data.model.Transaction;
import com.example.cuciin_android.data.model.register.RegisterObj;
import com.example.cuciin_android.data.model.login.LoginObj;
import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
//import retrofit2.http.Header;
import retrofit2.http.Header;
import retrofit2.http.POST;

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
    Call<OutletTestObj> getOutlet();

    @GET("laundry/type")
    Call<LaundryType> getLaundryTypeAll(
            @Header("authorization") String token
    );

    @FormUrlEncoded
    @POST("transaction")
    Call<Transaction> addLundryTransaction(
            @Header("authorization") String token,
            @Field("address") String address,
            @Field("price") int price,
            @Field("amount") double amount,
            @Field("laundry_type") String laundry_type,
            @Field("status") String status,
            @Field("customer_id") int customer_id,
            @Field("outlet_id") int outlet_id
            );
}

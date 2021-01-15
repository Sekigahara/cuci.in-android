package com.example.cuciin_android.helper;

import com.example.cuciin_android.data.model.LaundryType;
import com.example.cuciin_android.data.model.OutletTestObj;
import com.example.cuciin_android.data.model.Transaction;
import com.example.cuciin_android.data.model.outlet_local.OutletLocal;
import com.example.cuciin_android.data.model.register.RegisterObj;
import com.example.cuciin_android.data.model.login.LoginObj;

import com.example.cuciin_android.data.model.transaction.TransactionObj;
import com.example.cuciin_android.data.model.user.UserObj;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
//import retrofit2.http.Header;
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
    Call<OutletTestObj> getOutlet();

    @GET("laundry/type")
    Call<LaundryType> getLaundryTypeAll(
            @Header("authorization") String token
    );

    @GET("info")
    Call<UserObj> getInfo(
            @Header("Authorization") String token
    );


    @GET("transaction/history/{user_id}")
    Call<TransactionObj> getHistoryTransaction(
            @Header("Authorization") String token,
            @Path("user_id") int user_id
    );

    @GET("outlet")
    Call<OutletLocal> getLocalOutlet(
            @Header("Authorization") String token
    );

    @FormUrlEncoded
    @POST("transaction")
    Call<Transaction> addLaundryTransaction(
            @Header("authorization") String token,
            @Field("address") String address,
            @Field("laundry_type") String laundry_type,
            @Field("outlet_id") String outlet_id,
            @Field("outlet_google_id") String google_id,
            @Field("status") String status
    );
}

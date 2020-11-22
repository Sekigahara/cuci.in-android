package com.example.cuciin_android.helper;

import com.example.cuciin_android.data.model.outlet.OutletObj;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiGoogleService {

    @GET("nearbysearch/json")
    Call<OutletObj> getNearestLaundry(
        @Query("type") String types,
        @Query("location") String location,
        @Query("radius") int radius,
        @Query("sensor") String sensor,
        @Query("key") String key
    );
}
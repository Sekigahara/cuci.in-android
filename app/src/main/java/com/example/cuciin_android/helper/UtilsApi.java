package com.example.cuciin_android.helper;

public class UtilsApi {
    public static final String BASE_URL_API="http://api.cuci-in.me/api/auth/";
    public static final String BASE_MAPS_URL_API="https://maps.googleapis.com/maps/api/place/";

    public static ApiService getLocalAPIService(){
        return RetrofitClient.getClient(BASE_URL_API).create(ApiService.class);
    }

    public static ApiGoogleService getGoogleApiService(){
        return RetrofitClient.getClient(BASE_MAPS_URL_API).create(ApiGoogleService.class);
    }
}
package com.example.cuciin_android.helper;

public class UtilsApi {
    public static final String BASE_URL_API="http://10.0.2.2:8000/api/auth/";

    public static ApiService getAPIService(){
        return RetrofitClient.getClient(BASE_URL_API).create(ApiService.class);
    }
}

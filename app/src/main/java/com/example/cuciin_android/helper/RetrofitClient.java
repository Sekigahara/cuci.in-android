package com.example.cuciin_android.helper;

import android.util.Log;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit = null;
    private static String baseUrlRetrofit = null;

    public static Retrofit getClient(String baseUrl) {
        Log.d("Retrofit URL", baseUrl);
        if(!baseUrl.equals(baseUrlRetrofit)) {
            baseUrlRetrofit = baseUrl;
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}

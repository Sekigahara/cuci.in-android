package com.example.cuciin_android.activity.modul.splash;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;

public class SplashPresenter implements SplashContract.Presenter{
    private final SplashContract.View view;

    public SplashPresenter(SplashContract.View view){
        this.view = view;
    }

    public void start(){

    }

    public Bitmap compressImages(Context context, int resource, int width, int height){
        Bitmap icon = BitmapFactory.decodeResource(context.getResources(), resource);
        return Bitmap.createScaledBitmap(icon, width, height, true);
    }
}
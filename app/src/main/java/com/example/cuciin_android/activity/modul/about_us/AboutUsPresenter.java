package com.example.cuciin_android.activity.modul.about_us;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class AboutUsPresenter implements AboutUsContract.Presenter{
    private final AboutUsContract.View view;

    public AboutUsPresenter(AboutUsContract.View view){
        this.view = view;
    }

    public void start(){

    }

    public Bitmap compressImages(Context context, int resource, int width, int height){
        Bitmap icon = BitmapFactory.decodeResource(context.getResources(), resource);
        return Bitmap.createScaledBitmap(icon, width, height, true);
    }
}
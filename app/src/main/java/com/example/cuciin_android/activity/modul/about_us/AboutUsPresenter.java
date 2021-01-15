package com.example.cuciin_android.activity.modul.about_us;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class AboutUsPresenter implements AboutUsContract.Presenter{
    private final AboutUsContract.View view;
    private final BitmapFactory.Options options = new BitmapFactory.Options();

    public AboutUsPresenter(AboutUsContract.View view){
        this.view = view;
    }

    public void start(){

    }

    public Bitmap compressImages(Context context, int resource, int width, int height){
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(context.getResources(), resource, options);

        options.inSampleSize = calculateInSampleSize(options, width, height);
        options.inJustDecodeBounds = false;

        return BitmapFactory.decodeResource(context.getResources(), resource, options);
        //Bitmap icon = BitmapFactory.decodeResource(context.getResources(), resource);
        //return Bitmap.createScaledBitmap(icon, width, height, true);
    }

    private int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight){
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) >= reqHeight
                    && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }
}
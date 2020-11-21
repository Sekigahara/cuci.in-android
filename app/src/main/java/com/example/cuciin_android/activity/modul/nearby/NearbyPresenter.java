package com.example.cuciin_android.activity.modul.nearby;

import android.os.AsyncTask;
import android.os.NetworkOnMainThreadException;
import android.util.Log;
import android.widget.Toast;

import com.example.cuciin_android.data.model.DataOutletObj;

import org.json.JSONObject;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.io.IOException;
import org.json.JSONException;

public class NearbyPresenter  implements NearbyContract.Presenter {
    private final NearbyContract.View view;

    public NearbyPresenter(NearbyContract.View view){
        this.view = view;
    }

    public void start(){

    }

    public String getGoogleQueryLink(String location, String radius, String API_KEY) {
        return "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=" + location + "&radius=" + radius + "&type=laundry&key=" + API_KEY;
    }
}

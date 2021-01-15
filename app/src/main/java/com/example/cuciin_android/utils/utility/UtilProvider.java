package com.example.cuciin_android.utils.utility;

import android.content.Context;

import com.example.cuciin_android.data.model.outlet.Location;
import com.example.cuciin_android.utils.session.UserSessionRepositoryRepository;
import com.google.android.libraries.places.api.model.Place;

import java.util.ArrayList;

public class UtilProvider {
    private static UserSessionUtil userSessionUtil;
    private static LocationUtil locationUtil;
    private static String key;
    private static String serverKey;

    public static void initUserSession(Context context){
        UserSessionRepositoryRepository userSession = new UserSessionRepositoryRepository(context);
        userSessionUtil = new UserSessionUtil(userSession);
    }

    public static void initServerKey(String key){
        serverKey = key;
    }

    public static void initLocationSession(Double lat, Double lng){
        locationUtil = new LocationUtil(new Location(lat, lng));
    }

    public static void initKey(String requiredKey){
        key = requiredKey;
    }

    public static UserSessionUtil getUserSessionUtil(){
        return userSessionUtil;
    }

    public static LocationUtil getLocationUtil(){
        return locationUtil;
    }

    public static String getKey(){
        return key;
    }

    public static String getServerKey(){
        return serverKey;
    }
}

package com.example.cuciin_android.utils.utility;

import com.example.cuciin_android.data.model.outlet.Location;

public class LocationUtil {
    Location location;

    public LocationUtil(Location location){
        this.location = location;
    }

    public Double getLocationLatitude(){
        return location.getLat();
    }

    public Double getLocationLongitude(){
        return location.getLng();
    }
}

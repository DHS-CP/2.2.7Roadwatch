package com.example.osnho.a227roadwatch;

import java.util.Map;

/**
 * Created by zhu56662 on 3/20/2018.
 */

public abstract class MapPlaceHolder {
    private double latitude;
    private double longitude;

    public MapPlaceHolder(double lat, double lon){
        latitude = lat;
        longitude = lon;
    }

    public double getLatitude(){
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public abstract String getInfo();
}

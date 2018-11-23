package com.kdev.droneformula.formulae;

import android.util.Log;

import static android.content.ContentValues.TAG;

public class HaversineDistanceHelper {

    private final int EARTH_RADIUS = 6371;
    private final int R_DEGREES = 180;

    private Double startLat;
    private Double startLong;
    private Double endLat;
    private Double endLong;

    public HaversineDistanceHelper(Double startLat, Double startLong, Double endLat, Double endLong) {
        this.startLat = startLat;
        this.startLong = startLong;
        this.endLat = endLat;
        this.endLong = endLong;
    }

    public Double getLatDist(){
        return toRad(endLat - startLat);
    }

    public Double getLongDist(){
        return toRad(endLong - startLong);
    }

    public Double toRad(Double value) {
        return value * Math.PI / R_DEGREES;
    }

    public Double getA() {
        return Math.sin(getLatDist() / 2) * Math.sin(getLatDist() / 2) +
               Math.cos(toRad(startLat)) * Math.cos(toRad(endLat)) *
               Math.sin(getLongDist() / 2) * Math.sin(getLongDist() / 2);
    }

    public Double getC() {
        return 2 * Math.atan2(Math.sqrt(getA()), Math.sqrt(1-getA()));
    }

    public Double getDistance() {
        return EARTH_RADIUS * getC();
    }
}

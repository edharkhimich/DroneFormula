package com.kdev.droneformula.formulas;

public class HaversineDistanceHelper {

    /* Made only one method public because we won't need another methods.
       If we will need some more methods - we can just change it on public.
    */

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

    private Double getLatDist(){
        return toRad(endLat - startLat);
    }

    private Double getLongDist(){
        return toRad(endLong - startLong);
    }

    private Double toRad(Double value) {
        return value * Math.PI / R_DEGREES;
    }

    private Double getA() {
        return Math.sin(getLatDist() / 2) * Math.sin(getLatDist() / 2) +
               Math.cos(toRad(startLat)) * Math.cos(toRad(endLat)) *
               Math.sin(getLongDist() / 2) * Math.sin(getLongDist() / 2);
    }

    private Double getC() {
        return Math.atan2(Math.sqrt(getA()), Math.sqrt(1-getA())) * 2;
    }

    public Double getDistance() {
        return EARTH_RADIUS * getC();
    }
}

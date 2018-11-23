package com.kdev.droneformula.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kdev.droneformula.formulae.HaversineDistanceHelper;
import com.kdev.droneformula.models.configuration.Config;
import com.kdev.droneformula.models.drone.Drone;
import com.kdev.droneformula.models.mission.Mission;

import java.io.File;
import java.io.IOException;

public class ConfigCalculator {

    private final int LANDING_ALTITUDES = 0;
    private final int METERS_IN_KM = 1000;

    private String configJSON;
    private String droneJSON;
    private String missionJSON;

    private int altitudeTime;

    private ObjectMapper objectMapper = new ObjectMapper();


    public ConfigCalculator(String configJSON, String droneJSON, String missionJSON) {
        this.configJSON = configJSON;
        this.droneJSON = droneJSON;
        this.missionJSON = missionJSON;
        startCalc();
    }

    private void startCalc(){
        try {
            getAltitudeTime();
            getPointsDistance();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getPointsDistance(){
        try {
            double startLat = getMissionJson(missionJSON).getPoints().get(0).getStart().getStartLatitude();
            double startLong = getMissionJson(missionJSON).getPoints().get(0).getStart().getStartLongitude();
            double rechargeLat = getMissionJson(missionJSON).getPoints().get(0).getRecharge().getRechargerLat();
            double rechargeLong = getMissionJson(missionJSON).getPoints().get(0).getRecharge().getRechargerLong();
            double endLat = getMissionJson(missionJSON).getPoints().get(0).getEnd().getEndLatitude();
            double endLong = getMissionJson(missionJSON).getPoints().get(0).getEnd().getEndLongitude();

            checkTripToFirstPoint(startLat, startLong, rechargeLat, rechargeLong);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void checkTripToFirstPoint(double xLat, double xLong, double yLat, double yLong) {
        getTripDistanceInMetres(xLat, xLong, yLat, yLong);
    }

    private void getTripDistanceInMetres(double xLat, double xLong, double yLat, double yLong) {
        HaversineDistanceHelper helper = new HaversineDistanceHelper(xLat, xLong, yLat, yLong);
        double distanceKm = helper.getDistance();
        double distanceMeters = METERS_IN_KM * distanceKm;
    }

    private void getAltitudeTime() throws IOException {
        int ascensionSpeed = getConfigJson(configJSON).getVerticalSpeeds().get(0).getAscension();
        int altitude = getMissionJson(missionJSON).getAltitude();
        int altitudeTimeInSec = altitude - LANDING_ALTITUDES / ascensionSpeed;
        System.out.println("Program in process...");
    }

    private Config getConfigJson(String jsonPath) throws IOException {
        File file = new File(jsonPath);
        Config config = objectMapper.readValue(file, Config.class);
        return config;
    }

    private Mission getMissionJson(String jsonPath) throws IOException {
        File file = new File(jsonPath);
        Mission mission = objectMapper.readValue(file, Mission.class);
        return mission;
    }

    private Drone getDroneJson(String jsonPath) throws IOException {
        File file = new File(jsonPath);
        Drone drone = objectMapper.readValue(file, Drone.class);
        return drone;
    }
}

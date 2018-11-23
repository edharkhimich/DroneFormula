package com.kdev.droneformula.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kdev.droneformula.models.configuration.Config;
import com.kdev.droneformula.models.drone.Drone;
import com.kdev.droneformula.models.mission.Mission;
import com.kdev.droneformula.models.mission.Points;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ConfigCalculator {

    private static final int LANDING_ALTITUDES = 0;

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
//        List<Points> = getMissionJson(missionJSON).getPoints();
        try {
            System.out.println(getMissionJson(missionJSON).getPoints().get(0).getStart().getStartLatitude());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getAltitudeTime() throws IOException {
        int ascensionSpeed = getConfigJson(configJSON).getVerticalSpeeds().get(0).getAscension();
        int altitude = getMissionJson(missionJSON).getAltitude();
        int altitudeTimeInSec = altitude / ascensionSpeed;
        System.out.println(altitudeTimeInSec);
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

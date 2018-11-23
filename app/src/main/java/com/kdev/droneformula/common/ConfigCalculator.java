package com.kdev.droneformula.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kdev.droneformula.models.configuration.Config;
import com.kdev.droneformula.models.drone.Drone;
import com.kdev.droneformula.models.mission.Mission;

import java.io.File;
import java.io.IOException;

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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getAltitudeTime() throws IOException {
        int ascensionSpeed = getConfigJson(configJSON).getVerticalSpeeds().get(0).getAscension();
        int altitude = getMissionJson(missionJSON).getAltitude();
        System.out.println("altitude " + altitude + "/ assentialSpeed " + ascensionSpeed);
    }

    public Config getConfigJson(String jsonPath) throws IOException {
        File file = new File(jsonPath);
        Config config = objectMapper.readValue(file, Config.class);
        return config;
    }

    public Mission getMissionJson(String jsonPath) throws IOException {
        File file = new File(jsonPath);
        Mission mission = objectMapper.readValue(file, Mission.class);
        return mission;
    }

    public Drone getDroneJson(String jsonPath) throws IOException {
        File file = new File(jsonPath);
        Drone drone = objectMapper.readValue(file, Drone.class);
        return drone;
    }
}

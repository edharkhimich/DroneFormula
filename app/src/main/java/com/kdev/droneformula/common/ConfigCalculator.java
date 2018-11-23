package com.kdev.droneformula.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kdev.droneformula.models.Drone;

import java.io.File;
import java.io.IOException;

public class ConfigCalculator {

    private String configJSON;
    private String droneJSON;
    private String missionJSON;

    public ConfigCalculator(String configJSON, String droneJSON, String missionJSON) {
        this.configJSON = configJSON;
        this.droneJSON = droneJSON;
        this.missionJSON = missionJSON;
        startCounting();
    }

    private void startCounting(){

    }


    private



    public void parseJSON() {
        ObjectMapper objectMapper = new ObjectMapper();

        File file = new File("/Users/apple/Documents/close/android_projects/DroneFormula/app/src/main/java/com/kdev/droneformula/json/drones/drone-X.json");

        Drone someClass = null;
        try {
            someClass = objectMapper.readValue(file, Drone.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(someClass.getForcedLandingCharge());
    }
}

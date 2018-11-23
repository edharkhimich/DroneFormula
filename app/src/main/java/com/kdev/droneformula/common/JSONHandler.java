package com.kdev.droneformula.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kdev.droneformula.models.Drone;

import java.io.File;
import java.io.IOException;

public class JSONHandler {


    private String JSONPath;

    public JSONHandler(String JSONPath) {
        this.JSONPath = JSONPath;
    }

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

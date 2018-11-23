package com.kdev.droneformula;

import com.kdev.droneformula.common.ConfigCalculator;

public class Main {

    private static final String CONFIG_JSON_PATH = "/Users/apple/Documents/close/android_projects/DroneFormula/app/src/main/java/com/kdev/droneformula/json/configurations/config-X.json";
    private static final String DRONE_JSON_PATH = "/Users/apple/Documents/close/android_projects/DroneFormula/app/src/main/java/com/kdev/droneformula/json/drones/drone-X.json";
    private static final String MISSION_JSON_PATH = "/Users/apple/Documents/close/android_projects/DroneFormula/app/src/main/java/com/kdev/droneformula/json/missions/mission-X.json";

    public static void main(String[] args) {

        ConfigCalculator calculator = new ConfigCalculator(CONFIG_JSON_PATH, DRONE_JSON_PATH, MISSION_JSON_PATH);
    }
}

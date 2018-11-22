package com.kdev.droneformula;

import com.kdev.droneformula.formulae.HaversineDistanceHelper;

public class Main {

    public static void main(String[] args) {
        HaversineDistanceHelper helper = new HaversineDistanceHelper(49.205995,-102.987480, 50.479158, -104.615710);

        System.out.println("Distance = " + helper.getDistance());
    }
}

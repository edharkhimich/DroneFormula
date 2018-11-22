package com.kdev.droneformula.formulae;

import android.util.Log;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static android.content.ContentValues.TAG;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class HaversineDistanceHelperTest {

    private final double START_LAT = 49.00;
    private final double START_LONG = -102.00;
    private final double END_LAT = 50.00;
    private final double END_LONG = -104.00;

    private final int EARTH_RADIUS = 6371;
    private final int R_DEGREES = 180;

    private HaversineDistanceHelper helper = new HaversineDistanceHelper(START_LAT, START_LONG, END_LAT, END_LONG);


    @Before
    public void chechHelperOnNotNullTest(){
        assertNotNull(helper);
    }

    @Test
    public void getLatDistTest(){
        assertEquals(0.017, helper.toRad(END_LAT - START_LAT), 0.001);
    }

    @Test
    public void getLongDistTest(){
        assertEquals(-0.034, helper.toRad(END_LONG - START_LONG), 0.001);
    }

    @Test
    public void getToRadTest(){
        double value = 5.00;
        assertEquals(0.087, helper.toRad(value), 0.001);
    }

    @Test
    public void getATest(){
        Double a = Math.sin(helper.getLatDist() / 2) * Math.sin(helper.getLatDist() / 2) +
                   Math.cos(helper.toRad(START_LAT)) * Math.cos(helper.toRad(END_LAT)) *
                   Math.sin(helper.getLongDist() / 2) * Math.sin(helper.getLongDist() / 2);
        assertEquals(2.045985596853705E-4, a, 0.01);
    }

    @Test
    public void getCTest(){
        assertEquals(0.0286, helper.getC(), 0.001);
    }

    @Test
    public void getDTest(){
        assertEquals(182.26, helper.getDistance(), 0.01);
    }


}

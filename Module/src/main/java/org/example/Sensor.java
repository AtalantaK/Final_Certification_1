package org.example;

import java.util.Random;

public class Sensor {
    public static double getHumidity() {
        Random random = new Random();
        return (double) Math.round(random.nextDouble(101) * 100) /100;
    }
}

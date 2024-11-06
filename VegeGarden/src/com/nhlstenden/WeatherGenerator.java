package com.nhlstenden;

import java.util.Random;

public class WeatherGenerator
{
    private static final int MINI_NUMBER_LUX = 1000;
    private static final int MAX_NUMBER_LUX = 101592;
    private static final int MAX_NUMBER_MM = 48;
    private static final int MINI_NUMBER_MM = 0;

    public static int generateRandomLux()
    {
        Random random = new Random();

        return random.nextInt(MINI_NUMBER_LUX, MAX_NUMBER_LUX + 1);
    }

    public static int generateRandomMM()
    {
        Random random = new Random();

        return random.nextInt(MINI_NUMBER_MM, MAX_NUMBER_MM + 1);
    }
}

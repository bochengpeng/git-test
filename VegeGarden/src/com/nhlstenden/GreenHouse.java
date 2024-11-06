package com.nhlstenden;

public class GreenHouse extends Garden
{
    private WeatherGenerator weatherGenerator;
    private static final int AMOUNT_OF_DAY = 1;

    public GreenHouse()
    {
        this.weatherGenerator = new WeatherGenerator();
    }

    public WeatherGenerator getWeatherGenerator()
    {
        return this.weatherGenerator;
    }

    public void setWeatherGenerator(WeatherGenerator weatherGenerator)
    {
        this.weatherGenerator = weatherGenerator;
    }

    public void runWeather()
    {
        int randomLux = WeatherGenerator.generateRandomLux();
        int randomMm = WeatherGenerator.generateRandomMM();

        for (Vegetable vegetable : this.getVegetables())
        {
            vegetable.grow(randomLux, randomMm, AMOUNT_OF_DAY);
        }
    }
}

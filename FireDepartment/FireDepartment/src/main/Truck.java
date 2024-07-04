package main;

import java.util.ArrayList;
import java.util.List;

public class Truck
{
    private double maxWaterLevel;
    private double currentWaterLevel;
    private List<Firefighter> firefighters;

    public Truck(double maxWaterLevel, double currentWaterLevel)
    {
        this.maxWaterLevel = maxWaterLevel;
        this.currentWaterLevel = currentWaterLevel;
        this.firefighters = new ArrayList<>();
    }

    public double getMaxWaterLevel()
    {
        return this.maxWaterLevel;
    }

    public void setMaxWaterLevel(double maxWaterLevel)
    {
        this.maxWaterLevel = maxWaterLevel;
    }

    public double getCurrentWaterLevel()
    {
        return this.currentWaterLevel;
    }

    public void setCurrentWaterLevel(double currentWaterLevel)
    {
        this.currentWaterLevel = currentWaterLevel;
    }

    public List<Firefighter> getFirefighters()
    {
        return this.firefighters;
    }

    public void setFirefighters(List<Firefighter> firefighters)
    {
        this.firefighters = firefighters;
    }

    public void deployPerson(Firefighter firefighter)
    {
        this.getFirefighters().add(firefighter);
    }
}

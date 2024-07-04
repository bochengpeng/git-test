package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Firedepartment
{
    private List<Firefighter> firefighters;
    private List<Truck> trucks;
    private List<Emergency> emergencies;

    public Firedepartment()
    {
        this.firefighters = new ArrayList<>();
        this.trucks = new ArrayList<>();
        this.emergencies = new ArrayList<>();
    }

    public List<Firefighter> getFirefighters()
    {
        return this.firefighters;
    }

    public void setFirefighters(List<Firefighter> firefighters)
    {
        this.firefighters = firefighters;
    }

    public List<Truck> getTrucks()
    {
        return this.trucks;
    }

    public void setTrucks(List<Truck> trucks)
    {
        this.trucks = trucks;
    }

    public List<Emergency> getEmergencies()
    {
        return this.emergencies;
    }

    public void setEmergencies(List<Emergency> emergencies)
    {
        this.emergencies = emergencies;
    }

    public void addFirefighter(Firefighter firefighter)
    {
        this.getFirefighters().add(firefighter);
    }

    public void removeFirefighter(Firefighter person)
    {
        Iterator<Firefighter> iterator = this.firefighters.iterator();
        while (iterator.hasNext())
        {
            Firefighter firefighter = iterator.next();
            if (firefighter == person)
            {
                iterator.remove();
            }
        }
    }


    public Truck selectTruck(Emergency emergency)
    {
        for (Truck truck : this.getTrucks())
        {
            if (truck.getCurrentWaterLevel() >= emergency.getEstimatedWaterLevel())
            {
                return truck;
            }
        }

        System.out.println("No qualified truck");

        return null;
    }

    public List<Firefighter> assignFirefighter(Emergency emergency)
    {
        List<Firefighter> selectedFirefighter = new ArrayList<>();
        if (!this.getFirefighters().isEmpty())
        {
            for (Firefighter firefighter : this.getFirefighters())
            {
                if (emergency.getPriority() < 2 && emergency.getPriority() >= 0 && selectedFirefighter.size() <5)
                {
                    if (firefighter.getWorkingExperience() > 10)
                    {
                        selectedFirefighter.add(firefighter);
                    }
                }

                if (emergency.getPriority() > 2 && emergency.getPriority() <= 6 && selectedFirefighter.size() <5)
                {
                    selectedFirefighter.add(firefighter);
                }
            }

            return selectedFirefighter;
        }

        return null;
    }


    public void deployFirefighterAndTruck(Emergency emergency)
    {
        Truck selectedTruck = this.selectTruck(emergency);
        emergency.setTruck(selectedTruck);
        List<Firefighter> selectedFirefighter = this.assignFirefighter(emergency);
        selectedTruck.setFirefighters(selectedFirefighter);
    }

    public void terminateEmergency(Emergency targetEmergency)
    {
        for (Emergency emergency : this.getEmergencies())
        {
            if (emergency == targetEmergency)
            {
                emergency.completeEmergency();
                this.firefighters.removeAll(emergency.getTruck().getFirefighters());
            }
        }
    }

    public void reportIncident(String description, int priority, double estimatedWaterLevel)
    {
        Emergency emergency = new Emergency(String description, int priority, double estimatedWaterLevel);
        this.emergencies.add(emergency);
        this.assignFirefighter(emergency);
        this.deployFirefighterAndTruck(emergency);
    }
}

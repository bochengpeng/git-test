package main;

public class Emergency
{
    private String description;
    private int priority;
    private boolean completion;
    private double estimatedWaterLevel;
    private Truck truck;

    public Emergency(String description, int priority, double estimatedWaterLevel)
    {
        this.description = description;
        this.priority = priority;
        this.completion = false;
        this.estimatedWaterLevel = estimatedWaterLevel;
        this.truck = null;
    }

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public int getPriority()
    {
        return this.priority;
    }

    public void setPriority(int priority)
    {
        if (priority >= 0 && priority <=6)
        {
            this.priority = priority;
        }else
        {
            throw new RuntimeException("Invalid priority value");
        }
    }

    public boolean isCompletion()
    {
        return this.completion;
    }

    public void setCompletion(boolean completion)
    {
        this.completion = completion;
    }

    public double getEstimatedWaterLevel()
    {
        return this.estimatedWaterLevel;
    }

    public void setEstimatedWaterLevel(double estimatedWaterLevel)
    {
        this.estimatedWaterLevel = estimatedWaterLevel;
    }

    public Truck getTruck()
    {
        return this.truck;
    }

    public void setTruck(Truck truck)
    {
        this.truck = truck;
    }

    public void completeEmergency()
    {
        this.setCompletion(true);
        this.setTruck(null);
    }

}

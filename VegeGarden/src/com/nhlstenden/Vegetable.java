package com.nhlstenden;

public abstract class Vegetable
{
    protected double sizeInCm;
    private double cmPerLux;
    private double cmPerMillimeter;
    private int ripeLength;
    private Color color;
    private Status status;

    public Vegetable(double sizeInCm, double cmPerLux, double cmPerMillimeter, int ripeLength, Color color)
    {
        this.sizeInCm = sizeInCm;
        this.cmPerLux = cmPerLux;
        this.cmPerMillimeter = cmPerMillimeter;
        this.ripeLength = ripeLength;
        this.color = color;
        this.status = Status.GROWING;
    }

    public double getSizeInCm()
    {
        return this.sizeInCm;
    }

    public void setSizeInCm(double sizeInCm)
    {
        this.sizeInCm = sizeInCm;
    }

    public double getCmPerLux()
    {
        return this.cmPerLux;
    }

    public void setCmPerLux(double cmPerLux)
    {
        this.cmPerLux = cmPerLux;
    }

    public double getCmPerMillimeter()
    {
        return this.cmPerMillimeter;
    }

    public void setCmPerMillimeter(double cmPerMillimeter)
    {
        this.cmPerMillimeter = cmPerMillimeter;
    }

    public int getRipeLength()
    {
        return this.ripeLength;
    }

    public void setRipeLength(int ripeLength)
    {
        this.ripeLength = ripeLength;
    }

    public Color getColor()
    {
        return this.color;
    }

    public void setColor(Color color)
    {
        this.color = color;
    }

    public Status getStatus()
    {
        return this.status;
    }

    public void setStatus(Status status)
    {
        this.status = status;
    }

    public abstract void grow(int lux, int mm, int amountOfDays);
}

package com.nhlstenden;

public class Asparagus extends Vegetable implements Saleable
{
    private static final double CM_PER_LUX = 0.000027;
    private static final double CM_PER_MM = 0.0049;
    private static final int RIPE_LENGTH = 20;
    private static final int MAX_LENGTH = 29;
    private static final double PRICE_PER_CM = 0.12;

    public Asparagus()
    {
        super(0, CM_PER_LUX, CM_PER_MM, RIPE_LENGTH, Color.BLUE);
    }

    @Override
    public void grow(int lux, int mm, int amountOfDays)
    {
        if (mm > 40 && amountOfDays == 6)
        {
            this.setStatus(Status.DESTROYED);
        }

        this.sizeInCm += ( lux * CM_PER_LUX + mm * CM_PER_MM );

        if (this.getSizeInCm() >= 20)
        {
            this.setStatus(Status.READY_TO_HARVEST);
        }
    }

    @Override
    public boolean isSaleable()
    {
        return this.getSizeInCm() <= MAX_LENGTH && this.getSizeInCm() > 20;
    }

    @Override
    public double getPrice()
    {
        return this.sizeInCm * PRICE_PER_CM;
    }
}

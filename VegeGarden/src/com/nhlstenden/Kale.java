package com.nhlstenden;

public class Kale extends Vegetable
{
    private static final double CM_PER_LUX = 0.0057;
    private static final double CM_PER_MM = 0.032;
    private static final int RIPE_LENGTH = 16;

    public Kale()
    {
        super(0, CM_PER_LUX, CM_PER_MM, RIPE_LENGTH, Color.YELLOW);
    }

    @Override
    public void grow(int lux, int mm, int amountOfDays)
    {
        if (mm > 40 && amountOfDays == 6)
        {
            this.sizeInCm += 0;
        }

        this.sizeInCm += (lux * CM_PER_LUX + mm * CM_PER_MM);

        if (this.getSizeInCm() >= 16)
        {
            this.setStatus(Status.READY_TO_HARVEST);
        }
    }
}

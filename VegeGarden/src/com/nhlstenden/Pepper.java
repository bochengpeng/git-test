package com.nhlstenden;

public class Pepper extends Vegetable implements Saleable
{
    private static final double CM_PER_LUX = 0.000044;
    private static final double CM_PER_MM = 0.0013;
    private static final int RIPE_LENGTH = 7;
    private static final int MAX_LENGTH = 21;
    private static final int MINI_LENGTH = 15;
    private static final double PRICE_PER_CM = 0.15;

    public Pepper()
    {
        super(0, CM_PER_LUX, CM_PER_MM, RIPE_LENGTH, Color.PINK);
    }


    @Override
    public void grow(int lux, int mm, int amountOfDays)
    {
        if (mm > 31 && amountOfDays > 4)
        {
            this.setStatus(Status.DESTROYED);
        }

        if (mm < 25 && amountOfDays == 10)
        {
            this.sizeInCm += 0;
        }

        super.generalGrowth(lux, mm);
    }

    @Override
    public boolean isSaleable()
    {
        return this.getSizeInCm() >= MINI_LENGTH && this.getSizeInCm() <= MAX_LENGTH;
    }

    @Override
    public double getPrice()
    {
        return this.sizeInCm * PRICE_PER_CM;
    }
}

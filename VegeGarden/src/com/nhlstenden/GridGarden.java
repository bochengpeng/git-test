package com.nhlstenden;

import java.util.HashSet;
import java.util.Set;

public class GridGarden
{
    private static final int ROW_AMOUNT = 16;
    private static final int COLUMN_AMOUNT = 34;
    private final Vegetable[][] garden;

    public GridGarden()
    {
        this.garden = new Vegetable[ROW_AMOUNT][COLUMN_AMOUNT];
    }

    public Vegetable[][] getGarden()
    {
        return this.garden;
    }

    public void addVegetable(Vegetable vegetable) throws TooManyVegetablesException
    {
        for (int row = 0; row < this.garden.length; row++)
        {
            for (int column = 0; column < this.garden[row].length; column++)
            {
                if (this.garden[row][column] == null)
                {
                    this.garden[row][column] = vegetable;

                    return;
                }
            }
        }

        throw new TooManyVegetablesException();
    }

    public Set<Vegetable> getReadyForHarvestVegetables()
    {
        HashSet<Vegetable> harvestVegetables = new HashSet<>();

        for (int row = 0; row < this.garden.length; row++)
        {
            for (int column = 0; column < this.garden[row].length; column++)
            {
                Vegetable vegetable = this.garden[row][column];
                if (vegetable != null && vegetable.getStatus() == Status.READY_TO_HARVEST)
                {
                    harvestVegetables.add(vegetable);
                }
            }
        }

        return harvestVegetables;
    }
}

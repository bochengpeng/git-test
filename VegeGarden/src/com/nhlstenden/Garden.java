package com.nhlstenden;

import java.util.HashSet;
import java.util.Set;

public class Garden
{
    private static final int MAX_AMOUNT_VEGETABLES = 27;
    private Set<Vegetable> vegetables;

    public Garden()
    {
        this.vegetables = new HashSet<>();
    }

    public Set<Vegetable> getVegetables()
    {
        return this.vegetables;
    }

    public void setVegetables(Set<Vegetable> vegetables)
    {
        this.vegetables = vegetables;
    }

    public HashSet<Vegetable> getReadyForHarvest()
    {
        HashSet<Vegetable> vegetablesForHarvest = new HashSet<>();
        for (Vegetable vegetable : this.vegetables)
        {
            if (vegetable.getStatus() == Status.READY_TO_HARVEST)
            {
                vegetablesForHarvest.add(vegetable);
            }
        }

        return vegetablesForHarvest;
    }

    public boolean checkVegetableAmount() throws TooManyVegetablesException
    {
        if (this.vegetables.size() > MAX_AMOUNT_VEGETABLES)
        {
            throw new TooManyVegetablesException();
        }

        return true;
    }

    public void addVegetable(Vegetable vegetable) throws TooManyVegetablesException
    {
        if (this.checkVegetableAmount())
        {
            this.vegetables.add(vegetable);
        }
    }
}

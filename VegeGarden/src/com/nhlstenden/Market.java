package com.nhlstenden;

import java.util.HashSet;
import java.util.Set;

public class Market
{
    private Set<Saleable> saleableSet;

    public Market()
    {
        this.saleableSet = new HashSet<>();
    }

    public Set<Saleable> getSaleableSet()
    {
        return this.saleableSet;
    }

    public void setSaleableSet(Set<Saleable> saleableSet)
    {
        this.saleableSet = saleableSet;
    }

    public double CalculateTotalProfits()
    {
        double totalProfits = 0;
        for (Saleable saleable : this.saleableSet)
        {
            if (saleable.isSaleable())
            {
                totalProfits += saleable.getPrice();
            }
        }

        return totalProfits;
    }
}

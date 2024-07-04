package main;

import java.time.LocalDate;
import java.time.Period;

public class Firefighter
{
    private String name;
    private LocalDate dateEntered;

    public Firefighter(String name, LocalDate dateEntered)
    {
        this.name = name;
        this.dateEntered = dateEntered;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public LocalDate getDateEntered()
    {
        return this.dateEntered;
    }

    public void setDateEntered(LocalDate dateEntered)
    {
        this.dateEntered = dateEntered;
    }

    public double getWorkingExperience()
    {
        LocalDate today = LocalDate.now();

        return Period.between(this.getDateEntered(), today).getYears();
    }
}

package main;

import java.util.ArrayList;
import java.util.List;

public class Block
{
    private List<Locker> lockers;

    public Block()
    {
        this.lockers = new ArrayList<>();
    }

    public List<Locker> getLockers()
    {
        return this.lockers;
    }

    public void setLockers(List<Locker> lockers)
    {
        this.lockers = lockers;
    }

    public void addLocker(Locker locker)
    {
        this.lockers.add(locker);
    }

    public Locker selectLocker(String number)
    {
        for (Locker locker : this.lockers)
        {
            if (locker.getLockerNumber().equals(number) && locker.isAvailability())
            {
                return locker;
            }
        }

        return null;
    }

    public void useLocker(String lockerNumber, Laptop laptop)
    {
        Locker selectedLocker = this.selectLocker(lockerNumber);
        selectedLocker.reserveLocker();
        selectedLocker.setLaptop(laptop);
        System.out.println("Locker " + lockerNumber + " has been used");
    }

    public List<Locker> getAvailableLockerList()
    {
        List<Locker> lockerList = new ArrayList<>();
        for (Locker locker : this.lockers)
        {
            if (locker.isAvailability() && locker.getLaptop() == null)
            {
                lockerList.add(locker);
            }
        }

        return lockerList;
    }

    public Locker getLaptopLockerMostCurrentMAh()
    {
        Locker qualifiedLocker = null;
        for (Locker locker : this.lockers)
        {
            if (qualifiedLocker == null)
            {
                qualifiedLocker = locker;
            }

            if (locker.getLaptop().getmAhCurrent() > qualifiedLocker.getLaptop().getmAhCurrent())
            {
                qualifiedLocker = locker;
            }
        }

        return qualifiedLocker;
    }

    public Locker getLaptopLockerHighestBattery()
    {
        Locker qualifiedLocker = null;
        for (Locker locker : this.lockers)
        {
            if (qualifiedLocker == null)
            {
                qualifiedLocker = locker;
            }

            if (locker.getLaptop().getBatteryPercentage() > qualifiedLocker.getLaptop().getBatteryPercentage())
            {
                qualifiedLocker = locker;
            }

            if (locker.getLaptop().getBatteryPercentage() == qualifiedLocker.getLaptop().getBatteryPercentage())
            {
                qualifiedLocker = this.getLaptopLockerMostCurrentMAh();
            }
        }

        return qualifiedLocker;
    }

    public Locker getFirstAvailbleLocker()
    {
        Locker firstavailableLocker = null;
        for (Locker locker : this.lockers)
        {
            if (locker.isAvailability() && locker.getLaptop() == null)
            {
                firstavailableLocker = locker;

                return firstavailableLocker;
            }

            if (firstavailableLocker == null && !locker.isAvailability() && locker.getLaptop() != null)
            {
                firstavailableLocker = this.getLaptopLockerHighestBattery();
            }
        }

        return firstavailableLocker;
    }

    public double getHoursFullyChargeAllLaptop()
    {
        double T = 0;
        for (Locker locker : this.lockers)
        {
            T += locker.getLaptop().getPercentageToFull();
        }

        return T / 522;
    }
}

package main;

public class Locker
{
    private String lockerNumber;
    private Laptop laptop;
    private boolean availability;

    public Locker(String lockerNumber)
    {
        this.lockerNumber = lockerNumber;
        this.laptop = null;
        this.availability = true;
    }

    public String getLockerNumber()
    {
        return this.lockerNumber;
    }

    public void setLockerNumber(String lockerNumber)
    {
        this.lockerNumber = lockerNumber;
    }

    public Laptop getLaptop()
    {
        return this.laptop;
    }

    public void setLaptop(Laptop laptop)
    {
        this.laptop = laptop;
    }

    public boolean isAvailability()
    {
        return this.availability;
    }

    public void setAvailability(boolean availability)
    {
        this.availability = availability;
    }

    public void reserveLocker()
    {
        if (this.availability && this.laptop == null)
        {
            this.setAvailability(false);
        }
    }

    public void releaseLocker()
    {
        this.setAvailability(true);
        this.setLaptop(null);
    }
}

package main;

public class Laptop
{
    private String serialNumber;
    private double mAhCurrent;
    private double mAhMax;

    public Laptop(String serialNumber, double mAhCurrent, double mAhMax)
    {
        this.serialNumber = serialNumber;
        this.mAhCurrent = mAhCurrent;
        this.mAhMax = mAhMax;
    }

    public String getSerialNumber()
    {
        return this.serialNumber;
    }

    public void setSerialNumber(String serialNumber)
    {
        this.serialNumber = serialNumber;
    }

    public double getmAhCurrent()
    {
        return this.mAhCurrent;
    }

    public void setmAhCurrent(double mAhCurrent)
    {
        this.mAhCurrent = mAhCurrent;
    }

    public double getmAhMax()
    {
        return this.mAhMax;
    }

    public void setmAhMax(double mAhMax)
    {
        this.mAhMax = mAhMax;
    }

    public double getBatteryPercentage()
    {
        if (this.getmAhMax() != 0)
        {
            return (this.mAhCurrent / this.mAhMax) * 100;
        }

        throw new RuntimeException("mAhMax can't be zero");
    }

    public double getPercentageToFull()
    {
        return 100 - this.getBatteryPercentage();
    }
}

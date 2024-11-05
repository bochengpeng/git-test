public class Student
{
    private String name;

    public Student(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return 0;
    }

    public void studentHard()
    {
        this.setName("tom");
    }
}

package com.nhlstenden;

public class Student
{
    private String name;
    private int age;

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
        return this.age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public void studentHard()
    {
        this.setName("tom");
    }
}

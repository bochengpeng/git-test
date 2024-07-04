package test;

import main.Emergency;
import main.Firedepartment;
import main.Firefighter;
import main.Truck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class FiredepartmentTest
{
    private Emergency e1;
    private Emergency e2;
    private Firedepartment firedepartment;
    private Truck t1;
    private Truck t2;
    private Firefighter f1;
    private Firefighter f2;
    private Firefighter f3;
    private Firefighter f4;
    private Firefighter f5;

    @BeforeEach
    void setUp()
    {
        e1 = new Emergency("fire inside house", 1, 60);
        e2 = new Emergency("fire inside house", 5, 60);
        firedepartment = new Firedepartment();
        t1 = new Truck(100, 60);
        t2 = new Truck(50, 40);
        f1 = new Firefighter("Tim", LocalDate.of(2000,12, 25));
        f2 = new Firefighter("Thijs", LocalDate.of(2003,11, 25));
        f3 = new Firefighter("Frank", LocalDate.of(2005, 12, 10));
        f4 = new Firefighter("John", LocalDate.of(2008, 2, 10));
        f5 = new Firefighter("Rick", LocalDate.of(2009, 1, 10));
        firedepartment.getTrucks().add(t2);
        firedepartment.addFirefighter(f1);
        firedepartment.addFirefighter(f2);
        firedepartment.addFirefighter(f3);
        firedepartment.addFirefighter(f4);
        firedepartment.addFirefighter(f5);
    }

    @Test
    void selectTruck_EmergencyPriorityOne_t1ExpectPass()
    {
        firedepartment.getTrucks().add(t1);
        assertEquals(t1, firedepartment.selectTruck(e1));
    }

    @Test
    void selectTruck_EmergencyPriorityOne_NullExpectPass()
    {
        assertEquals(null, firedepartment.selectTruck(e1));
    }

    @Test
    void assignFirefighter_EmergencyPriorityOne_FiveExpectPass()
    {
        assertEquals(5, firedepartment.assignFirefighter(e1).size());
    }

    @Test
    void assignFirefighter_EmergencyPriorityFive_FiveExpectPass()
    {
        assertEquals(5, firedepartment.assignFirefighter(e2).size());
    }

    @Test
    void deployFirefighterAndTruck_EmergencyPriorityFive_FiveExpectPass()
    {
        firedepartment.getTrucks().add(t1);
        firedepartment.deployFirefighterAndTruck(e1);
        assertEquals(5, e1.getTruck().getFirefighters().size());
    }

    @Test
    void terminateEmergency_EmergencyPriorityFive_ExpectNull()
    {
        firedepartment.getEmergencies().add(e1);
        firedepartment.getTrucks().add(t1);
        firedepartment.deployFirefighterAndTruck(e1);
        firedepartment.terminateEmergency(e1);
        assertTrue(e1.isCompletion());
    }
}
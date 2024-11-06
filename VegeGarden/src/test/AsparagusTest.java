package test;

import com.nhlstenden.Asparagus;
import com.nhlstenden.Status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AsparagusTest
{
    private Asparagus a1;

    @BeforeEach
    void setUp()
    {
        a1 = new Asparagus();
    }

    @Test
    void grow_mmThirty_SixDays_ExpectGrowing()
    {
        a1.grow(100, 30, 6);
        assertEquals(Status.GROWING, a1.getStatus());
    }

    @Test
    void grow_mmThirty_SevenDays_ExpectGrowing()
    {
        a1.grow(100, 30, 7);
        assertEquals(Status.GROWING, a1.getStatus());
    }

    @Test
    void grow_mmForty_SixDays_ExpectGrowing()
    {
        a1.grow(100, 40, 6);
        assertEquals(Status.GROWING, a1.getStatus());
    }

    @Test
    void grow_mmForty_SevenDays_ExpectGrowing()
    {
        a1.grow(100, 40, 6);
        assertEquals(Status.GROWING, a1.getStatus());
    }

    @Test
    void grow_mmFortyOne_SixDays_ExpectGrowing()
    {
        a1.grow(100, 41, 6);
        assertEquals(Status.DESTROYED, a1.getStatus());
    }

    @Test
    void grow_mmFortyOne_SevenDays_ExpectGrowing()
    {
        a1.grow(100, 41, 7);
        assertEquals(Status.GROWING, a1.getStatus());
    }

    @Test
    void grow_sizeTwenty_ExpectGrowing()
    {
        a1.grow(4060, 4060, 7);
        assertEquals(Status.READY_TO_HARVEST, a1.getStatus());
    }

    @Test
    void grow_sizeHigherTwenty_ExpectGrowing()
    {
        a1.grow(5000, 5000, 7);
        assertEquals(Status.READY_TO_HARVEST, a1.getStatus());
    }

    @Test
    void grow_sizeLowerTwenty_ExpectGrowing()
    {
        a1.grow(4059, 4059, 7);
        assertEquals(Status.GROWING, a1.getStatus());
    }
}
package test;

import com.nhlstenden.Asparagus;
import com.nhlstenden.Garden;
import com.nhlstenden.TooManyVegetablesException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GardenTest
{
    private Garden g1;

    @BeforeEach
    void setUp()
    {
        g1 = new Garden();
    }

    @Test
    void  addVegetable_LowerThanMax_ExpectEquals() throws TooManyVegetablesException
    {

        for (int i = 0; i < 26; i++)
        {
            g1.addVegetable(new Asparagus());
        }

        assertEquals(26, g1.getVegetables().size());
    }

    @Test
    void  addVegetable_EqualsMaxLimit_ExpectEquals() throws TooManyVegetablesException
    {

        for (int i = 0; i < 27; i++)
        {
            g1.addVegetable(new Asparagus());
        }

        assertEquals(27, g1.getVegetables().size());
    }

    @Test
    void  addVegetable_OverMaxLimit_ExpectEquals() throws TooManyVegetablesException
    {

        for (int i = 0; i < 28; i++)
        {
            g1.addVegetable(new Asparagus());
        }

        assertThrows(Exception.class,()->g1.checkVegetableAmount());
    }
}
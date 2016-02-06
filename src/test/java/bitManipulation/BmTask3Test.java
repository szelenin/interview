package bitManipulation;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by szelenin on 2/6/2016.
 */
public class BmTask3Test {
    @Test
    public void should(){
        assertEquals(0b111, BmTask3.nextMin(0b10110));
        assertEquals(0b11100000000000000000000000000000, BmTask3.nextMax(0b10110));
        assertEquals(0b1, BmTask3.nextMin(0b1));
        assertEquals(0b10000000000000000000000000000000, BmTask3.nextMax(0b1));
        assertEquals(0b0, BmTask3.nextMin(0b0));
        assertEquals(0b0, BmTask3.nextMax(0b0));
    }

}
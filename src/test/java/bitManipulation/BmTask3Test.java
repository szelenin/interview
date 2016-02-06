package bitManipulation;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by szelenin on 2/6/2016.
 */
public class BmTask3Test {
    @Test
    public void should(){
        assertEquals(0b10101, BmTask3.nextMin(0b10110));
        assertEquals(0b11001, BmTask3.nextMax(0b10110));
        assertEquals(0b0, BmTask3.nextMin(0b0));
        assertEquals(0b0, BmTask3.nextMax(0b0));
    }

}
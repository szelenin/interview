package bitManipulation;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by szelenin on 2/4/2016.
 */
public class BmTask1Test {
    @Test
    public void should(){
        assertEquals(0b10001001100, BmTask1.insertBits(0b10000000000, 0b10011, 2, 6));
    }

}
package bitManipulation;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by szelenin on 2/6/2016.
 */
public class BmTask6Test {
    @Test
    public void should(){
        assertEquals(0b00111001, BmTask6.swapBits(0b00110110));
    }

}
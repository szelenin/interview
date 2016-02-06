package bitManipulation;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by szelenin on 2/6/2016.
 */
public class BmTask5Test {
    @Test
    public void shouldMySolution(){
        assertEquals(1, BmTask5.numBits(0, 1));
        assertEquals(1, BmTask5.numBits(1, 0));
        assertEquals(2, BmTask5.numBits(0b01, 0b10));
        assertEquals(1, BmTask5.numBits(0b101, 0b100));
    }

    @Test
    public void shouldBookSolution(){
        assertEquals(1, BmTask5.numBitsBook(0, 1));
        assertEquals(1, BmTask5.numBitsBook(1, 0));
        assertEquals(2, BmTask5.numBitsBook(0b01, 0b10));
        assertEquals(1, BmTask5.numBitsBook(0b101, 0b100));
    }

    @Test
    public void shouldBookSolution2(){
        assertEquals(1, BmTask5.numBitsBook2(0, 1));
        assertEquals(1, BmTask5.numBitsBook2(1, 0));
        assertEquals(2, BmTask5.numBitsBook2(0b01, 0b10));
        assertEquals(1, BmTask5.numBitsBook2(0b101, 0b100));
    }

}
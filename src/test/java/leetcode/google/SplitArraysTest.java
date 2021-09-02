package leetcode.google;

import org.junit.Test;

import static org.junit.Assert.*;

public class SplitArraysTest {
    @Test
    public void testSplitArrays() {
        SplitArrays splitArrays = new SplitArrays();
        assertEquals(9, splitArrays.splitArray(new int[]{1,2,3,4,5}, 2));
        assertEquals(18, splitArrays.splitArray(new int[]{7,2,5,10,8}, 2));
    }

    @Test
    public void testSplitArraysDP() {
        SplitArraysDP splitArrays = new SplitArraysDP();
        assertEquals(9, splitArrays.splitArray(new int[]{1,2,3,4,5}, 2));
        assertEquals(18, splitArrays.splitArray(new int[]{7,2,5,10,8}, 2));
    }
}
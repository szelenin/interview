package leetcode.google.prepare;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestPalindromeTest {
    @Test
    public void testLongestPalindrome() {
        assertEquals("aca", new LongestPalindrome().longestPalindrome("aacabdkacaa"));
    }
}
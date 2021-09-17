package leetcode.google.prepare;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestPalindromeTest {
    @Test
    public void testLongestPalindrome() {
        assertEquals("bb", new LongestPalindrome().longestPalindrome("cbbd"));
        assertEquals("aca", new LongestPalindrome().longestPalindrome("aacabdkacaa"));
    }

    @Test
    public void testLongestPalindromeDP() {
        assertEquals("aba", new LongestPalindromeDP().longestPalindrome("babad"));
    }
}
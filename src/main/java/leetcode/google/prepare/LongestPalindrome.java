package leetcode.google.prepare;
//https://leetcode.com/problems/longest-palindromic-substring/
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        String maxPalindrome = "" + s.charAt(0);
        int[] palindromeStartLen = new int[2];
        for (int i = 0; i < s.length(); i++) {
            findPalindrome(s, i, palindromeStartLen);
            if (palindromeStartLen[1] > maxPalindrome.length()) {
                maxPalindrome = s.substring(palindromeStartLen[0], palindromeStartLen[0] + palindromeStartLen[1]);
            }
        }
        return maxPalindrome;
    }

    private void findPalindrome(String s, int pos, int[] result) {
        //if palindrome length is odd (has a symbol in center, "aba")
        int leftOdd = pos;
        int rightOdd = pos;
        //if palindrome length is even (aa)
        int leftEven = pos;
        int rightEven = pos + 1;
        boolean oddPalindrome = true;
        boolean evenPalindrome = true;
        int oddLen = 1;
        int evenLen = 0;
        int oddStart = pos;
        int evenStart = pos;
        while (oddPalindrome || evenPalindrome) {
            oddPalindrome = oddPalindrome && leftOdd >= 0 && rightOdd < s.length() && s.charAt(leftOdd) == s.charAt(rightOdd);
            evenPalindrome = evenPalindrome && leftEven >= 0 && rightEven < s.length() && s.charAt(leftEven) == s.charAt(rightEven);
            if (oddPalindrome) {
                oddLen = rightOdd - leftOdd + 1;
                oddStart = leftOdd;
            }
            if (evenPalindrome) {
                evenLen = rightEven - leftEven + 1;
                evenStart = leftEven;
            }
            leftOdd--;
            rightOdd++;
            leftEven--;
            rightEven++;
        }
        if (oddLen > evenLen) {
            result[0] = oddStart;
            result[1] = oddLen;
        } else {
            result[0] = evenStart;
            result[1] = evenLen;
        }
    }

}

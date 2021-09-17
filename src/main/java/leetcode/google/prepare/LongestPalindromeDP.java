package leetcode.google.prepare;

public class LongestPalindromeDP {
        private boolean[][] p;
        public String longestPalindrome(String s) {
            //dp approach:
            //1 -symbol is palindrome
            //2 symbols is palindrome if s(i) == s(i+1)
            //3 sumbols is palindrome if s(i) == s(i+2) && s(i) is palindrome
            //4 symbols is palindrome if s(i) == s(i+3) && s(i+1..i+2) is a palindrome
            //let's store isPalindrome(s,i,len) in a table p. Then s(i,len) is a palindrome if s(i)==s(i+len-1) && isPalindrome(s,i+1,i+len-2)
            p = new boolean[s.length()][s.length()];
            String maxPalindrome = "";
            for (int l=1;l<=s.length();l++){
                for (int i = 0; i <= s.length() - l; i++){
                    if (isPalindrome(s, i, l)) {
                        maxPalindrome = s.substring(i, i + l);
                    }
                }
            }
            return maxPalindrome;
        }

        private boolean isPalindrome(String s, int i, int l) {
            if (l == 1) {
                p[i][l - 1] = true;
                return true;
            }
            if (l == 2) {
                p[i][l - 1] = s.charAt(i) == s.charAt(i+1);
                return p[i][l - 1];
            }
            p[i][l - 1] = p[i + 1][l - 2 - 1] && s.charAt(i) == s.charAt(i + l - 1);
            return  p[i][l - 1];
        }

}

package leetcode.google;
//this works: https://leetcode.com/explore/interview/card/google/67/sql-2/472/
//mistakes:
//1: need to calculate end of group after character has been processed: needed -1 here: s.length() - i - -1
public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String s, int k) {
        //we can do substrings but it is not efficient because each substring creates a new string
        //iterate over string chars
        //for every char at index i
        //add c.toUpperCase()
        //-end of group? (s.length - i) % k == 0: add ('-')

        //ab,1 -> A-B
        //ab,2 -> AB
        //abc,2 -> A-BC
        //a,2 -> A

        s = s.replaceAll("-", "");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(Character.toUpperCase(s.charAt(i)));
            if ((s.length() - i - 1) % k == 0 && i < s.length() - 1) {
                sb.append('-');
            }
        }
        return sb.toString();
    }
}

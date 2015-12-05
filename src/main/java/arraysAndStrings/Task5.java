package arraysAndStrings;

/**
 * Created by szelenin on 12/5/2015.
 */
public class Task5 {
    public static String compress(String s){
        StringBuffer sb = new  StringBuffer();
        for (int i=0;i<s.length();i++){
            int sameCount = 1;
            char currentChar = s.charAt(i);
            while (i+1 < s.length() && currentChar == s.charAt(i+1)) {
                sameCount++;
                i++;
            }
            sb.append(currentChar).append(sameCount);
        }
        String result = sb.toString();
        return result.length() < s.length() ? result : s;
    }
}

package arraysAndStrings;

/**
 * Created by szelenin on 12/5/2015.
 */
public class Task4 {
    public static String replaceSpaces(String s, int trueLen) {
        char[] chars = s.toCharArray();
        char[] result = new char[chars.length];
        int j = 0;
        for (int i = 0; i < trueLen; i++) {
            if (chars[i] != 0x20) {
                result[j] = chars[i];
                j++;
                continue;
            }
            result[j] = '%';
            result[++j] = '2';
            result[++j] = '0';
            j++;
        }
        return new String(result);
    }
}

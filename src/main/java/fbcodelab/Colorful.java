package fbcodelab;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by Sergii_Zelenin on 1/2/2017.
 * https://codelab.interviewbit.com/problems/colorful/
 */
public class Colorful {
    public int colorful(int a) {
        // get list of contigious subsequence
        // get numbers with amount of digits from 1 to length of string ""+a
        String aStr = ""+a;
        ArrayList<String> result = new ArrayList<>();
        for (int size=1; size<=aStr.length(); size++){
            for (int start=0; start <= aStr.length()-size; start++){
                result.add(aStr.substring(start, start+size));
            }
        }

        //multiply each digit in sequence, put in hash set and compare sizes
        HashSet<Integer> set = new HashSet<>();
        for (String number : result) {
            int mult = 1;
            for (int i=0; i<number.length(); i++){
                mult *= Integer.parseInt(""+number.charAt(i));
            }
            set.add(mult);
        }
        return set.size() == result.size()? 1 : 0;
    }

}

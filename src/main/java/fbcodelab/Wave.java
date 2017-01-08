package fbcodelab;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Sergii_Zelenin on 1/8/2017.
 */
public class Wave {
    public ArrayList<Integer> wave(ArrayList<Integer> a) {
        Collections.sort(a);
        for (int i=0,j=1; j<a.size(); i+=2,j+=2){
            int tmp = a.get(i);
            a.set(i, a.get(j));
            a.set(j, tmp);
        }
        return a;
    }

}

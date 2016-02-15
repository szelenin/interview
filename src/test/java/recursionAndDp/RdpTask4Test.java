package recursionAndDp;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by szelenin on 2/15/2016.
 */
public class RdpTask4Test {
    @Test
    public void should(){
        List<int[]> ints = RdpTask4.allSubsets(3);
        String s = toString(ints);
        System.out.println("s = " + s);
    }

    private String toString(List<int[]> ints) {
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        for (int[] intArray : ints) {
            sb.append(Arrays.toString(intArray)).append("\n");
        }
        sb.append("]");
        return sb.toString();
    }

}
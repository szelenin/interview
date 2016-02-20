package other;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by szelenin on 2/19/2016.
 */
public class LISTest {
    @Test
    public void should(){
        assertEquals("[2]",  LIS.lis(Collections.singletonList(2)).toString());
        assertEquals("[2, 3]", LIS.lis(Arrays.asList(2,3)).toString());
        assertEquals("[2, 3]", LIS.lis(Arrays.asList(5,2,3)).toString());

        assertEquals("[2, 4, 5]", LIS.lis(Arrays.asList(2,6,4,5,1,3)).toString());
    }

    @Test
    public void failedTestWithDP(){
        List<Integer> lis = LIS.lis(Arrays.asList(2, 4, 3, 5, 1, 7, 6, 9, 8));
        assertEquals("[2, 4, 5, 7, 9]", lis.toString());
    }
}
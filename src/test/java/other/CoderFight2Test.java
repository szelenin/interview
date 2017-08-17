package other;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by Sergii_Zelenin on 7/3/2017.
 */
public class CoderFight2Test {
    @Test
    public void test(){
        int[] newParent = CoderFight2.changeRoot(new int[]{0, 0, 0, 1, 1, 1, 2, 2, 7}, 7);
        assertArrayEquals(Arrays.toString(newParent), new int[]{2, 0, 7, 1, 1, 1, 2, 7, 7}, newParent);
    }

}
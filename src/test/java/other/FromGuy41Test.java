package other;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;
import static other.FromGuy41.rotate;

/**
 * Created by Sergii_Zelenin on 5/23/2016.
 */
public class FromGuy41Test {
    @Test
    public void test(){
        assertEquals("[5, 1, 2, 3, 4]", Arrays.toString(rotate(new int[]{1, 2, 3, 4, 5}, 1)));
        assertEquals("[4, 5, 1, 2, 3]", Arrays.toString(rotate(new int[]{1, 2, 3, 4, 5}, 2)));
        assertEquals("[4, 5, 1, 2, 3]", Arrays.toString(rotate(new int[]{1, 2, 3, 4, 5}, 2 + 5)));
    }


}
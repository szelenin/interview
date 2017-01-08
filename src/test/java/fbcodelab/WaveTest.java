package fbcodelab;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by Sergii_Zelenin on 1/8/2017.
 */
public class WaveTest {
    @Test
    public void test(){
        assertEquals(Arrays.asList(2,1,4,3,5), new Wave().wave(new ArrayList<>(Arrays.asList(5, 1, 3, 2, 4))));
    }
}
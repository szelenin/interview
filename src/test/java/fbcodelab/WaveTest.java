package fbcodelab;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

/**
 * Created by Sergii_Zelenin on 1/8/2017.
 */
public class WaveTest {
    @Test
    public void test(){
        assertEquals(Arrays.asList(2,1,4,3,5), new Wave().wave(new ArrayList<>(Arrays.asList(5, 1, 3, 2, 4))));
        ArrayList<Integer> integers = new ArrayList<>();
        integers.stream().filter((tree)->tree >= 0).collect(Collectors.toList());
    }
}
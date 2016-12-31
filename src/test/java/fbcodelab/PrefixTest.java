package fbcodelab;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by Sergii_Zelenin on 12/31/2016.
 */
public class PrefixTest {
    @Test
    public void test(){
        assertEquals("[bea, ber]", prefix("bearcat", "bert"));
        assertEquals("[abcd, abce, abd]", prefix("abcd", "abce", "abd"));
        assertEquals("[abcd, abce, abd]", prefix("abcdf", "abce", "abd"));
    }

    private String prefix(String... strings) {
        ArrayList<String> result = new Prefix().prefix(Arrays.asList(strings));
        return result.toString();
    }

}
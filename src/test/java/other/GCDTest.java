package other;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sergii_Zelenin on 8/21/2017.
 */
public class GCDTest {
    @Test
    public void test(){
        assertEquals(61232, GCD.gcd(3918848, 1653264));
        assertEquals(61232, GCD.gcd(1653264, 3918848));
    }

}
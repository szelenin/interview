package other;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by szelenin on 3/7/2016.
 */
public class PowerOf3Test {
    @Test
    public void should(){
        assertEquals(2, PowerOf3.powerOf3(9), 0.001);
        assertEquals(3, PowerOf3.powerOf3(27), 0.001);
    }

    @Test
    public void should2(){
        double value = Math.pow(3, 2.098);
        System.out.println("value = " + value);
    }
    @Test
    public void shouldDecimals(){
        assertEquals(10, Math.pow(3, PowerOf3.powerOf3(10)), 0.001);
        assertEquals(Math.log(10)/Math.log(3), PowerOf3.powerOf3(10), 0.001);
        assertEquals(3, PowerOf3.powerOf3(27), 0.001);
    }

}
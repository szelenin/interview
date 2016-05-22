package other;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sergii_Zelenin on 5/20/2016.
 */
public class FromGuy48LSPTest {
    @Test
    public void test(){
        double[] array = new double[]{0.5, 0.9, -2.5, 3.0, -5.0};
        assertEquals(-2.5 * 3.0 * (-5.0), FromGuy48LSP.MaxSubsequentProduct(array), 0.0001);
    }


    @Test
    public void test1(){
        double[] array = new double[]{0.5, 2.5, 0.0, 5.0, 2.0};
        assertEquals(5.0 * 2.0, FromGuy48LSP.MaxSubsequentProduct(array), 0.0001);
    }

    @Test
    public void testSimple(){
        double[] array = new double[]{0.5, 2.5, 3.0, 0.0, 2.0};
        assertEquals(2.5 * 3.0, FromGuy48LSP.MaxSubsequentProduct(array), 0.0001);
    }

}
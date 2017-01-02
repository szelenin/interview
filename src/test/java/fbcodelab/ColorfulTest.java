package fbcodelab;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sergii_Zelenin on 1/2/2017.
 */
public class ColorfulTest {
    @Test
    public void test(){
        assertEquals(1, new Colorful().colorful(23));
    }

    @Test
    public void test2(){
        "123".substring(2, 3);
        assertEquals(0, new Colorful().colorful(123));
    }
}
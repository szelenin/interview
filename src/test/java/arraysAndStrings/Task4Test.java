package arraysAndStrings;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by szelenin on 12/5/2015.
 */
public class Task4Test {
    @Test
    public void should(){
        String string = "Mr John Smith";
        assertEquals("Mr%20John%20Smith", Task4.replaceSpaces(string + "          ", string.length()).trim());
    }

}
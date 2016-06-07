package other;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sergii_Zelenin on 6/5/2016.
 */
public class FromGuy33Test {
    @Test
    public void test(){
        assertEquals("World Hello", FromGuy33.reverseWords("Hello World"));
        assertEquals("here I'm Hi", FromGuy33.reverseWords("Hi I'm here"));
    }

    @Test
    public void test2(){
        assertEquals("World Hello", FromGuy33.reverseWords2("Hello World"));
        assertEquals("here I'm Hi", FromGuy33.reverseWords2("Hi I'm here"));
    }

}
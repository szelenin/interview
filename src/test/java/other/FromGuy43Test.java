package other;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Sergii_Zelenin on 5/22/2016.
 */
public class FromGuy43Test {
    @Test
    public void test(){
        //2,7
        assertEquals("[[b, g]]", FromGuy43.decipherWays(new int[]{2, 7}).toString());
        //2,6;26
        assertEquals("[[b, f], [z]]", FromGuy43.decipherWays(new int[] {2,6}).toString());
        //2,2,1;22,1;2,21
        //?? Errors.
        assertEquals("[[b, b, a], [b, v], [v, a]]", FromGuy43.decipherWays(new int[] {2,2,1}).toString());
    }

}
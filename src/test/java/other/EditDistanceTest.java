package other;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sergii_Zelenin on 8/22/2017.
 */
public class EditDistanceTest {
    @Test
    public void testDistance(){
        assertEquals(5, EditDistance.distance("EDITING", "DISTANCE"));
    }

}
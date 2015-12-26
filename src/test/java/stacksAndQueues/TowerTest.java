package stacksAndQueues;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by szelenin on 12/17/2015.
 */
public class TowerTest {
    @Test
    public void should(){
        Tower tower = new Tower();
        tower.add(1);

        assertEquals(1, tower.pop());
    }
}
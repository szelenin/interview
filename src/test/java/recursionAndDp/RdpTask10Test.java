package recursionAndDp;

import org.junit.Test;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by szelenin on 2/29/2016.
 */
public class RdpTask10Test {
    @Test
    public void should(){
        List<RdpTask10.Box> boxes = Arrays.asList(new RdpTask10.Box(2, 3, 2), new RdpTask10.Box(3, 4, 3), new RdpTask10.Box(1, 2, 1), new RdpTask10.Box(2, 8, 4));
        List<RdpTask10.Box> stack = RdpTask10.stack(boxes);
        System.out.println("stack = " + stack);
    }

}
package recursionAndDp;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by szelenin on 2/21/2016.
 */
public class RdpTask6Test {
    @Test
    public void should(){
        List<String> strings = RdpTask6.addParent(3);
        System.out.println("strings = " + strings);
    }

}
package recursionAndDp;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by szelenin on 2/29/2016.
 */
public class RdpTask9Test {
    @Test
    public void should(){
        List<List<RdpTask9.Point>> lists = RdpTask9.queensPos();
        String s = toString(lists);
        System.out.println("s = " + s);
    }

    private String toString(List<List<RdpTask9.Point>> positions) {
        StringBuilder sb = new StringBuilder();
        positions.stream().forEach((list)->sb.append(list).append("\n"));
        return sb.toString();
    }

}
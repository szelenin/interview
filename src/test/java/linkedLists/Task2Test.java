package linkedLists;

import org.junit.Test;

import static linkedLists.Task2.iterate;
import static org.junit.Assert.*;

/**
 * Created by szelenin on 12/12/2015.
 */
public class Task2Test {

    @Test
    public void shouldGetLastK(){
        Node node = new Node(1, new Node(0));

        Result result = new Result();
        iterate(node, 1, result);
        assertEquals(1, result.node.data);
    }

    @Test
    public void shouldGetLastK2(){
        Node node = new Node(1, new Node(2, new Node(3)));

        Result result = new Result();
        iterate(node, 2, result);
        assertEquals(1, result.node.data);
    }
}
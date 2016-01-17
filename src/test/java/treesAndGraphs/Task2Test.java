package treesAndGraphs;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by szelenin on 1/17/2016.
 */
public class Task2Test {
    @Test
    public void should(){
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, Arrays.asList(2));
        graph.put(2, Arrays.asList(1, 4));
        graph.put(3, Collections.emptyList());
        graph.put(4, Arrays.asList(1, 5));

        assertTrue(Task2.hasRoute(graph, 1,1));
        assertTrue(Task2.hasRoute(graph, 1,2));
        assertTrue(Task2.hasRoute(graph, 1,5));
        assertFalse(Task2.hasRoute(graph, 1,3));
    }

}
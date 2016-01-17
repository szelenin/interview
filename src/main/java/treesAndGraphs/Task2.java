package treesAndGraphs;

import java.util.*;

/**
 * Created by szelenin on 1/17/2016.
 */
public class Task2 {
    public static boolean hasRoute(Map<Integer, List<Integer>> graph, int from, int to) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(from);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (node == to) {
                return true;
            }
            if (visited.contains(node)) {
                continue;
            }
            visited.add(node);
            List<Integer> children = graph.get(node);
            if (children == null) {
                continue;
            }
            for (Integer child : children) {
                queue.add(child);
            }
        }
        return false;
    }
}

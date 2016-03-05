package linkedLists;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by szelenin on 3/5/2016.
 */
public class ListUtils {
    private Set<Integer> visited = new HashSet<>();
    public String toString(Node node) {
        if (node == null || visited.contains(node.data)) {
            return "null";
        }
        visited.add(node.data);
        return node + "," + toString(node.next);
    }
}

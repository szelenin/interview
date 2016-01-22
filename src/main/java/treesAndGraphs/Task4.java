package treesAndGraphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by szelenin on 1/22/2016.
 */
public class Task4 {
    public static Map<Integer, List<String>> createList(TreeNode root) {
        HashMap<Integer, List<String>> result = new HashMap<>();
        preOrder(root, 0, result);
        return result;
    }

    private static void preOrder(TreeNode node, int level, HashMap<Integer, List<String>> result) {
        if (node == null) {
            return;
        }
        List<String> nodes = result.get(level);
        if (nodes == null) {
            nodes = new LinkedList<>();
            result.put(level, nodes);
        }
        nodes.add(node.name);
        preOrder(node.left, level + 1, result);
        preOrder(node.right, level + 1, result);
    }
}

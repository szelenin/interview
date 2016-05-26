package treesAndGraphs;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by Sergii_Zelenin on 5/24/2016.
 */
public class PrintTreeByLevelBorysovTest {
    @Test
    public void test1() {
        TreeNode leaf2 = new TreeNode(new TreeNode(4), new TreeNode(5), "" + 2);
        TreeNode leaf3 = new TreeNode(new TreeNode(6), new TreeNode(7), "" + 3);
        TreeNode root = new TreeNode(leaf2, leaf3, "1");
        assertEquals("[1, 23, 4567]", printTree(root).toString());
    }

    @Test
    public void test2() {
        TreeNode leaf2 = new TreeNode(new TreeNode(4), new TreeNode(5), "" + 2);
        TreeNode leaf3 = new TreeNode(3);
        TreeNode root = new TreeNode(leaf2, leaf3, "1");
        assertEquals("[1, 23, 45]", printTree(root).toString());
    }

    //          1
    //        2   3
    //       4 5 6 7
    // ER: 1; 2,3; 4,5,6,7
    //          1
    //        2   3
    //       4 5
    // ER: 1; 2,3; 4,5

    private List<String> printTree(TreeNode root) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, root));
        Map<Integer, String> result = new LinkedHashMap<>();
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            String row = result.get(pair.level);
            if (row == null) {
                row = pair.node.name;
            } else {
                row += pair.node.name;
            }
            result.put(pair.level, row);
            if (pair.node.left != null) {
                queue.add(new Pair(pair.level + 1, pair.node.left));
            }
            if (pair.node.right != null) {
                queue.add(new Pair(pair.level + 1, pair.node.right));
            }
        }
        return new ArrayList<>(result.values());
    }

    private static class Pair {
        public int level;
        public TreeNode node;

        public Pair(int level, TreeNode node) {
            this.level = level;
            this.node = node;
        }
    }

}
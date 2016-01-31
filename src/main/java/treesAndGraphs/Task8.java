package treesAndGraphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by szelenin on 1/31/2016.
 */
public class Task8 {
    public static boolean isSubtree(TreeNode root1, TreeNode root2) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root1);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (treesEqual(node, root2)) {
                return true;
            }
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return false;
    }

    private static boolean treesEqual(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) {
            return true;
        }
        if (n1 == null || n2 == null) {
            return false;
        }
        return n1.value() == n2.value() && treesEqual(n1.left, n2.left) && treesEqual(n1.left, n2.left);
    }

    public static boolean isSubtree2(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (treesEqual(root1, root2)) {
            return true;
        }
        return isSubtree2(root1.left, root2) || isSubtree2(root1.left, root2);
    }
}

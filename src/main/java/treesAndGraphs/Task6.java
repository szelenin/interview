package treesAndGraphs;

/**
 * Created by szelenin on 1/25/2016.
 */
public class Task6 {
    public static TreeNode next(TreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.right != null) {
            return firstInOrder(node.right);
        }
        if (isLeftChild(node)) {
            return node.parent;
        }
        return findForRightChild(node);
    }

    private static TreeNode findForRightChild(TreeNode node) {
        TreeNode parent = node.parent;
        while (parent != null) {
            if (isLeftChild(parent)) {
                return parent.parent;
            }
            parent = parent.parent;
        }
        return null;
    }

    private static boolean isLeftChild(TreeNode node) {
        return node.parent != null && node.parent.left == node;
    }

    private static TreeNode firstInOrder(TreeNode node) {
        TreeNode current = node;
        while (current.left != null || current.right != null) {
            if (current.left != null) {
                current = current.left;
                continue;
            }
            current = current.right;
        }
        return current;
    }

}

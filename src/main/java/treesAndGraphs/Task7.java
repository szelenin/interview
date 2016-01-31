package treesAndGraphs;

/**
 * Created by szelenin on 1/26/2016.
 */
public class Task7 {
    public static TreeNode findCommon(TreeNode n1, TreeNode n2) {
        if (n1 == null || n2 == null) {
            return null;
        }
        if (isParent(n1, n2)) {
            return n1.parent;
        }

        TreeNode current = n1;
        while (current.parent != null) {
            if (current.parent == n2.parent) {
                return current.parent;
            }
            TreeNode searchNode = current.parent.left == current ? current.parent.right : current.parent.left;
            if (search(searchNode, n2)) {
                return current.parent;
            }
            current = current.parent;
        }
        return null;
    }

    private static boolean isParent(TreeNode parent, TreeNode node) {
        TreeNode current = node;
        while (current != null) {
            if (current == parent) {
                return true;
            }
            current = current.parent;
        }
        return false;
    }

    private static boolean search(TreeNode node, TreeNode toFind) {
        if (node == toFind) {
            return true;
        }
        if (node == null) {
            return false;
        }
        return search(node.left, toFind) || search(node.right, toFind);
    }

    /* The below code has a bug. */
    public static TreeNode commonAncestorBad(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p && root == q) {
            return root;
        }

        TreeNode x = commonAncestorBad(root.left, p, q);
        if (x != null && x != p && x != q) { // Already found ancestor
            return x;
        }

        TreeNode y = commonAncestorBad(root.right, p, q);
        if (y != null && y != p && y != q) { // Already found ancestor
            return y;
        }


        if (x != null && y != null) { // p and q found in diff. subtrees
            return root; // This is the common ancestor
        } else if (root == p || root == q) {
            return root;
        } else {
             /* If either x or y is non-null, return the non-null value */
            return x == null ? y : x;
        }
    }
}

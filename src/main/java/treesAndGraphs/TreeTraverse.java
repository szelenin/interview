package treesAndGraphs;

/**
 * Created by szelenin on 1/14/2016.
 */
public class TreeTraverse {
    public String path = "";

    public void preOrder(TreeNode current) {
        if (current == null) {
            return;
        }
        path+=current;
        if (current.left != null) {
            preOrder(current.left);
        }
        if (current.right != null) {
            preOrder(current.right);
        }
    }

    public void inOrder(TreeNode current) {
        if (current == null) {
            return;
        }
        if (current.left != null) {
            inOrder(current.left);
        }
        path+=current;
        if (current.right != null) {
            inOrder(current.right);
        }
    }

    public void postOrder(TreeNode current) {
        if (current == null) {
            return;
        }
        if (current.left != null) {
            postOrder(current.left);
        }
        if (current.right != null) {
            postOrder(current.right);
        }
        path+=current;
    }
}

package treesAndGraphs;

/**
 * Created by szelenin on 3/6/2016.
 */
public class FromGuy45 {
    public static String counterClockwiseOrder(TreeNode root) {
        String left = preOrderForLeft(root);
        String down = postOrderForLeaves(root);
        String right = inOrderForRight(root.right);
        return left + down + right;
    }

    private static String inOrderForRight(TreeNode node) {
        if (node.right.right == null) { // don't print leaf nodes
            return node.toString();
        }
        return inOrderForRight(node.right) + node;
    }

    private static String postOrderForLeaves(TreeNode node) {
        if (node.left == null) { // no need to check for node.right since it is a full tree
            return node.toString();
        }
        return postOrderForLeaves(node.left) + postOrderForLeaves(node.right);
    }

    private static String preOrderForLeft(TreeNode node) {
        if (node.left.left == null) {// don't print leaf node
            return node.toString();
        }
        return node + preOrderForLeft(node.left);
    }
}

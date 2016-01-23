package treesAndGraphs;

/**
 * Created by szelenin on 1/23/2016.
 */
public class Task5 {
    public static boolean isBst(TreeNode root) {
        return isBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBst(TreeNode node, int min, int max) {
        if (node == null) {
            return true;
        }
        if (node.value() <= min || node.value() > max) {
            return false;
        }
        return isBst(node.left, min, node.value()) && isBst(node.right, node.value(), max);
    }


}

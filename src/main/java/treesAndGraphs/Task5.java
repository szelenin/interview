package treesAndGraphs;

/**
 * Created by szelenin on 1/23/2016.
 */
public class Task5 {
    public static boolean isBst(TreeNode root) {
        return traverse(root).isBst;
    }

    private static Result traverse(TreeNode node) {
        if (node == null) {
            return new Result(Integer.MIN_VALUE, Integer.MAX_VALUE, true);
        }
        Result left = traverse(node.left);
        if (left.max > node.value()) {
            return new Result(Integer.MAX_VALUE, Integer.MIN_VALUE, false);
        }
        Result right = traverse(node.right);
        if (right.min <= node.value()) {
            return new Result(Integer.MAX_VALUE, Integer.MIN_VALUE, false);
        }
        return new Result(Math.max(right.max, Math.max(node.value(), left.max)), Math.min(left.min, Math.min(node.value(), right.min)), true);
    }

    private static class Result {
        int min;
        int max;
        boolean isBst;

        public Result(int min, int max, boolean isBst) {
            this.min = min;
            this.max = max;
            this.isBst = isBst;
        }
    }
}

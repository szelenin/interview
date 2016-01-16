package treesAndGraphs;

/**
 * Created by szelenin on 1/16/2016.
 */
public class Task1 {
    public static Result isBalanced(TreeNode node) {
        if (node == null) {
            return new Result(0, true);
        }
        Result left = isBalanced(node.left);
        Result right = isBalanced(node.right);
        return new Result(left.len + right.len + 1,
                Math.abs(left.len - right.len) < 2 &&
                        left.balanced && right.balanced);
    }

    public static class Result {
        int len;
        boolean balanced;

        public Result(int len, boolean balanced) {
            this.len = len;
            this.balanced = balanced;
        }
    }
}

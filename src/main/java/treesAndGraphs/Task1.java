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
        return new Result(Math.max(left.height, right.height) + 1,
                Math.abs(left.height - right.height) < 2 &&
                        left.balanced && right.balanced);
    }

    public static class Result {
        int height;
        boolean balanced;

        public Result(int height, boolean balanced) {
            this.height = height;
            this.balanced = balanced;
        }
    }
}

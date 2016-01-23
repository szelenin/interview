package treesAndGraphs;

/**
 * Created by szelenin on 1/14/2016.
 */
public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public String name;

    public TreeNode(TreeNode left, TreeNode right, String name) {
        this.left = left;
        this.right = right;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public int value() {
        return Integer.parseInt(name);
    }
}

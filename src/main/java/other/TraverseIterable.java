package other;

import treesAndGraphs.TreeNode;

import java.util.Stack;

/**
 * Created by szelenin on 2/23/2016.
 */
public class TraverseIterable {
    public String path = "";
    public void inOrder(TreeNode node) {
        this.path = inOrderValue(node);
    }

    private Object[] step(Stack<TreeNode> parents, String left) {
        TreeNode node = parents.pop();
        if (left == null) {
            left = inOrderValue(node.left);
        }
        left += node;
        left += inOrderValue(node.right);

        return new Object[]{parents, left};
    }

    public String inOrderValue(TreeNode node) {
        if (node == null) {
            return "";
        }
        Stack<TreeNode> parents = new Stack<>();
        parents.push(node);
        return (String) step(parents, null)[1];
    }


}

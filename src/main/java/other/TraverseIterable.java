package other;

import treesAndGraphs.TreeNode;

import java.util.Stack;

/**
 * Created by szelenin on 2/23/2016.
 */
public class TraverseIterable {
    public String path = "";

    public Stack<TreeNode> step(Stack<TreeNode> parents, boolean left) {
        TreeNode node = parents.pop();
        if (!left) {
            inOrder(node.left);
        }
        path += node.name;
        inOrder(node.right);
        return parents;
    }

    public void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        Stack<TreeNode> parents = new Stack<>();
        while (node != null) {
            parents.push(node);
            node = node.left;
        }
        while (!parents.isEmpty()) {
            parents = step(parents, true);
        }
    }
}

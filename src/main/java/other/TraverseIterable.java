package other;

import treesAndGraphs.TreeNode;

import java.util.Stack;

/**
 * Created by szelenin on 2/23/2016.
 */
public class TraverseIterable {
    public String path = "";

    public Stack<TreeNode> step(Stack<TreeNode> parents, boolean right) {
        TreeNode node = parents.pop();
        path += node.name;
        if (!right) {
            inOrder(node.right);
        }
        return parents;
    }

    public void inOrder(TreeNode node) {
        Stack<TreeNode> parents = new Stack<>();
        while (node != null) {
            parents.push(node);
            node = node.left;
        }
        while (!parents.isEmpty()) {
            parents = step(parents, false);
        }
    }
}

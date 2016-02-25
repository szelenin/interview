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
            Stack<TreeNode> parents1 = new Stack<>();
            TreeNode node1 = node.right;
            while (node1 != null) {
                parents1.push(node1);
                node1 = node1.left;
            }
            while (!parents1.isEmpty()) {
                parents1 = step(parents1, false);
            }
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

    public void inOrder1(TreeNode node1) {
        Stack<TreeNode> parents1 = new Stack<>();
        while (node1 != null) {
            parents1.push(node1);
            node1 = node1.left;
        }
        while (!parents1.isEmpty()) {
            parents1 = step(parents1, false);
        }
    }
}

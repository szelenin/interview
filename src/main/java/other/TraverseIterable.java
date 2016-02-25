package other;

import treesAndGraphs.TreeNode;

import java.util.Stack;

/**
 * Created by szelenin on 2/23/2016.
 */
public class TraverseIterable {
    public String path = "";

    public void inOrder(TreeNode node) {
        Stack<TreeNode> parents = new Stack<>();
        traverseLeft(node, parents);
        while (!parents.isEmpty()) {
            node = parents.pop();
            path += node.name;
            node = node.right;
            traverseLeft(node, parents);
        }
    }

    private void traverseLeft(TreeNode node, Stack<TreeNode> parents) {
        while (node != null) {
            parents.push(node);
            node = node.left;
        }
    }

}

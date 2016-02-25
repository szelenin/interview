package other;

import treesAndGraphs.TreeNode;

import java.util.Stack;

/**
 * Created by szelenin on 2/23/2016.
 */
public class TraverseIterable {
    public String path = "";

    public Stack<TreeNode> step(Stack<TreeNode> parents) {
        TreeNode node = parents.pop();
        path += node.name;
        //--begin partial evaluation --
        Stack<TreeNode> parents1 = new Stack<>();
        TreeNode node1 = node.right;
        while (node1 != null) {
            parents1.push(node1);
            node1 = node1.left;
        }
        //--end partial evaluation --
        parents.addAll(parents1);
        return parents;
    }

    public void inOrder(TreeNode node) {
        Stack<TreeNode> parents = new Stack<>();
        while (node != null) {
            parents.push(node);
            node = node.left;
        }
        while (!parents.isEmpty()) {
            parents = step(parents);
        }
    }

}

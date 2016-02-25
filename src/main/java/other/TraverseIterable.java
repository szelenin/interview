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
        while (node != null) {
            parents.push(node);
            node = node.left;
        }
        while (!parents.isEmpty()) {
            node = parents.pop();
            path += node.name;
            //--begin partial evaluation --
            node = node.right;
            while (node != null) {
                parents.push(node);
                node = node.left;
            }
            //--end partial evaluation --
        }
    }

}

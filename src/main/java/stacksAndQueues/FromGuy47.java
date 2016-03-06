package stacksAndQueues;

import treesAndGraphs.TreeNode;

/**
 * Created by szelenin on 3/5/2016.
 */
public class FromGuy47 {

    public static String postOrderIter(TreeNode node) {
/*
        java.util.Stack<TreeNode> stack = new java.util.Stack<>();
        String result = ""; //base case
        while (node != null) {
            stack.push(node);
            node = node.left;
            if (node == null) {
                node = stack.pop();
                result += node;
                stack.push(node);
                node = node.right;
            }
        }

        if (node == null) {
            return "";
        }
        String left = postOrder(node.left); //push node to stack. node = node.left; Go to 1
                                            // node = pop from stack; result+=node
        String right = postOrder(node.right); //push node to stack. node = node.right; Go to 1
                                            // node = pop from stack; result+=node
        String result = left + right + node;
*/
        return "";
    }

    public static String postOrder(TreeNode node) {

        if (node == null) {
            return "";
        }
        String left = postOrder(node.left); //push node to stack. node = node.left; Go to 1
                                            // node = pop from stack; result+=node
        String right = postOrder(node.right); //push node to stack. node = node.right; Go to 1
                                            // node = pop from stack; result+=node
        String result = left + right + node;
        return result;
    }
}

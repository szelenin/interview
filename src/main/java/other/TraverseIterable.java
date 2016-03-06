package other;

import treesAndGraphs.TreeNode;

import java.util.Stack;

/**
 * Created by szelenin on 2/23/2016.
 */
public class TraverseIterable {
    public String path = "";

    public void inOrder(TreeNode node) {
        this.path = inorderIter(node);
    }

    public String inorderIter(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        String result = "";
        while (!stack.isEmpty()) {
            while (node.left != null) { //push to visit left branch
                node = node.left;
                stack.push(node);
            }
            node = stack.pop();
            result += node; //visit leftmost child
            while (node.right == null && !stack.isEmpty()) {
                node = stack.pop(); //get all left nodes until we have non empty right
                result += node;
            }
            if (node.right != null) {
                node = node.right;
                stack.push(node); // push to visit right branch
            }
        }
        return result;
    }

    public String inOrderValue(TreeNode node) {
        if (node == null) {
            return "";
        }
        String left = inOrderValue(node.left);
        String result = left + node;
        result += inOrderValue(node.right);
        return result;
    }


    public void preOrder(TreeNode root) {
        path = preOrderIter(root);
    }

    private String preOrderIter(TreeNode node) {
        String result = "";
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            result += node;
            while (node.left != null) {
                node = node.left;
                result += node;
                stack.push(node);
            }
            node = stack.pop();
            while (node.right == null && !stack.isEmpty()) {
                node = stack.pop();
            }
            if (node.right != null) {
                node = node.right;
                stack.push(node);
            }
        }
        return result;
    }

    private String preOrderValue(TreeNode node) {
        if (node == null) {
            return "";
        }
        String result = node.name;
        result += preOrderValue(node.left);
        result += preOrderValue(node.right);
        return result;
    }
}

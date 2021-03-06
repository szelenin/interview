package treesAndGraphs;

import java.util.*;
import java.util.stream.Collector;

// This is the text editor interface.
// Anything you type or change here will be seen by the other person in real time.
public class Main {
    public static void main(String[] args) {
        long a = 0b11000000000000000000000000000000L;
        System.out.println("a = " + a);
    }

    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode current = node;
        Stack<TreeNode> stack = new Stack<>();
        do {
            if (current != null) {
                stack.push(current);
                current = current.left;
                continue;
            }
            while (!stack.isEmpty()) {
                current = stack.pop();
                System.out.println(current.data);
                current = current.right;
                if (current != null) {
                    stack.push(current);
                }
            }
        } while (!stack.isEmpty());
    }

    public static void inOrder2(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder2(node.left);
        System.out.println("node = " + node);
        inOrder2(node.right);
    }
}
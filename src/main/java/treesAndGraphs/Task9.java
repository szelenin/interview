package treesAndGraphs;

import java.util.*;

/**
 * Created by szelenin on 2/1/2016.
 */
public class Task9 {
    public static class MyStack {
        private int value;
        private Set<String> paths = new HashSet<>();

        private LinkedList<TreeNode> stack = new LinkedList<>();

        public MyStack(int value) {
            this.value = value;
        }

        public void buildPaths() {
            if (stack.size() < 1) {
                return;
            }
            ListIterator<TreeNode> endIterator = stack.listIterator(1);
            ListIterator<TreeNode> startIterator = stack.listIterator(1);
            int currentValue = 0;
            while (endIterator.hasNext()) {
                TreeNode node = endIterator.next();
                currentValue += node.value();
                if (currentValue == value) {
                    addPath(startIterator.previousIndex() + 1, endIterator.previousIndex());
                    currentValue -= startIterator.next().value();
                }
                while (currentValue > value && startIterator.hasNext() && startIterator.nextIndex() < endIterator.nextIndex()) {
                    currentValue -= startIterator.next().value();
                }
            }
        }

        private void addPath(int startIndex, int endIndex) {
            StringBuilder sb = new StringBuilder();
            ListIterator<TreeNode> iterator = stack.listIterator(startIndex);
            while (iterator.hasNext() && iterator.nextIndex() <= endIndex) {
                sb.append(iterator.next().name);
            }
            paths.add(sb.toString());
        }


        public void push(TreeNode item) {
            stack.add(item);
        }


        public TreeNode pop() {
            return stack.removeLast();
        }
    }

    public static Set<String> paths(TreeNode root, int value) {
        MyStack stack = new MyStack(value);
        traverse(root, stack);
        return stack.paths;
    }

    private static void traverse(TreeNode node, MyStack stack) {
        if (node == null) {
            stack.push(null);
            return;
        }

        stack.push(node);
        if (isLeaf(node)) {
            stack.buildPaths();
            return;
        }
        traverse(node.left, stack);
        stack.pop();
        traverse(node.right, stack);
        stack.pop();
    }

    private static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}

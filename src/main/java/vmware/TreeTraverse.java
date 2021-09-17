package vmware;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TreeTraverse {

    public static class Node {
        public Node left;
        public Node right;
        public int value;

        public Node(Node left, Node right, int value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }
    }

    public static List<Integer> traverse(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        boolean isEven = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) { //iterate over all nodes of the same level. So we can add as usual (left, right) but retrieve in reverse/forward order
                if (isEven) { // (1) need: [3,2], but for the next level we need 4567
                    Node node = queue.removeLast();
                    result.add(node.value);
                    if (node.left != null) {
                        queue.addFirst(node.left);
                    }
                    if (node.right != null) {
                        queue.addFirst(node.right);
                    }
                } else { // []
                    Node node = queue.removeFirst();
                    result.add(node.value);
                    if (node.right != null) {
                        queue.addLast(node.right);
                    }
                    if (node.left != null) {
                        queue.addLast(node.left);
                    }
                }
            }
            isEven = !isEven;
        }
        return result;
    }

    static class NodeIterator {
        private LinkedList<Node> queue = new LinkedList<>();
        private boolean isEven = true;
        int i = 0;
        int size = 1;

        public NodeIterator(Node root) {
            if (root != null) {
                queue.addLast(root);
            }
        }
        //when do we know if hasNext == true? when queue is not empty
        public boolean hasNext() {
            return !queue.isEmpty();
        }

        //next is in the beginning or end of the list depending on isEven
        public int next() {
            if (!hasNext()) {
                throw new RuntimeException("Iterator does not have any more elements!");
            }
            if (i == size) {
                i = 0;
                size = queue.size();
                isEven = !isEven;
            }
            int result = 0;
            if (i < size) {
                if (isEven) {
                    Node node = queue.removeLast();//q:[1] -> r:[1], q[3,2] : for q[7,6,5,4] -> r: [1,3,2,4,5,6,7], q:[9,8]
                    result = node.value;
                    if (node.left != null) {
                        queue.addFirst(node.left);
                    }
                    if (node.right != null) {
                        queue.addFirst(node.right);
                    }
                } else { //q[3,2] -> r:[1,3,2], q[7,6,5,4] | q:[9,8] -> r:[1,3,2,4,5,6,7,9,8]
                    Node node = queue.removeFirst();
                    result = node.value;//[1,3,2]
                    if (node.right != null) {
                        queue.addLast(node.right);
                    }
                    if (node.left != null) {
                        queue.addLast(node.left);
                    }
                }
                i++;
            }
            return result;
        }

    }


    public static void main(String[] args) {
        Node node9 = new Node(null, null, 9);
        Node node8 = new Node(null, null, 8);
        Node node4 = new Node(node8, node9, 4);
        Node node5 = new Node(null, null, 5);
        Node node6 = new Node(null, null, 6);
        Node node7 = new Node(null, null, 7);
        Node node = new Node(new Node(node4, node5, 2), new Node(node6, node7, 3), 1);
        List<Integer> result = traverse(node);
        System.out.println("result = " + result);

        NodeIterator nodeIterator = new NodeIterator(node);
        while (nodeIterator.hasNext()) {
            System.out.println("nodeIterator.next() = " + nodeIterator.next());
        }
    }
}

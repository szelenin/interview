package linkedLists;

import java.util.Stack;

/**
 * Created by szelenin on 12/13/2015.
 */
public class Task7 {
    public static boolean isPalindrome(Node head){
        Stack<Node> stack = new Stack<>();
        for (Node current = head; current != null; current = current.next){
            stack.push(current);
        }
        for (Node current = head; current != null; current = current.next){
            if (stack.pop().data != current.data){
                return false;
            }
        }
        return true;
    }
}

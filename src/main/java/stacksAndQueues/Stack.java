package stacksAndQueues;

import linkedLists.Node;

/**
 * Created by szelenin on 12/13/2015.
 */
public class Stack {
    private Node top = null;
    public void push(int value){
        top = new Node(value, top);
    }
    public int peek() {
        if (top == null){
            throw new IllegalStateException();
        }

        return top.data;
    }
    public int pop(){
        if (top == null){
            throw new IllegalStateException();
        }
        int result = top.data;
        top = top.next;
        return result;
    }
    public boolean isEmpty(){
        return top == null;
    }
}


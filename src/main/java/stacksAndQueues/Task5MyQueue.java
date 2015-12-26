package stacksAndQueues;

import java.util.*;
import java.util.Stack;

/**
 * Created by szelenin on 12/26/2015.
 */
public class Task5MyQueue {
    private java.util.Stack stack1 = new java.util.Stack();
    private java.util.Stack stack2 = new java.util.Stack();

    public void put(int value) {
        stack1.push(value);
        int movedCount = stack2.size();
        moveStack(stack2, stack1, movedCount);
        stack2.push(value);
        moveStack(stack1, stack2, movedCount);
    }

    public int get(){
        if (stack2.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int result = (int) stack2.pop();
        int movedCount = stack1.size();
        moveStack(stack1, stack2, movedCount);
        stack2.pop();
        moveStack(stack2, stack1, movedCount - 1);
        return result;
    }

    private void moveStack(Stack src, Stack dest, int count) {
        for (int i = 0; i < count; i++) {
            dest.push(src.pop());
        }
    }
}

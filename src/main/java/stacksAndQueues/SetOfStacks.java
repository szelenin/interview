package stacksAndQueues;

import java.util.*;

/**
 * Created by szelenin on 12/14/2015.
 */
public class SetOfStacks {
    private final int threshhold;
    private final java.util.Stack<Stack> stacks = new java.util.Stack<>();
    private int currentCount;

    public SetOfStacks(int threshhold) {
        this.threshhold = threshhold;
    }
    public void push(int value){
        if (stacks.isEmpty() || currentCount == threshhold) {
            currentCount = 0;
            stacks.push(new Stack());
        }
        stacks.peek().push(value);
        currentCount++;
    }

    public int pop() {
        if (stacks.isEmpty()) {
            throw new IllegalStateException();
        }
        Stack top = stacks.peek();
        int result = top.pop();
        currentCount--;
        if (top.isEmpty()) {
            stacks.pop();
            currentCount = threshhold;
        }
        return result;
    }
}

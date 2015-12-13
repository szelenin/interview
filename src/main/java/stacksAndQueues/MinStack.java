package stacksAndQueues;

/**
 * Created by szelenin on 12/13/2015.
 */
public class MinStack extends Stack {
    private Stack min = new Stack();

    public void push(int value) {
        super.push(value);
        if (min.isEmpty() || value <= min.peek()) {
            min.push(value);
        }
    }

    public int pop() {
        int result = super.pop();
        if (result == min.peek()) {
            min.pop();
        }
        return result;
    }

    public int min() {
        return min.peek();
    }
}

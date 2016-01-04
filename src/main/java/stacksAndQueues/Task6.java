package stacksAndQueues;

import java.util.*;
import java.util.Stack;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by szelenin on 1/4/2016.
 */
public class Task6 {
    public static void sort(java.util.Stack s) {
        if (s.size() < 2) {
            return;
        }
        java.util.Stack helperStack = new Stack();
        while (moveStack(s, helperStack, Math::min)) {
            if (!moveStack(helperStack, s, Math::max)) {
                break;
            }
        }
        if (s.isEmpty()) {
            moveStack(helperStack, s, Math::max);
        }
    }

    private static boolean moveStack(Stack<Integer> src, Stack<Integer> dest, BiFunction<Integer, Integer, Integer> f) {
        int v1 = src.pop();
        boolean result = false;
        while (!src.isEmpty()) {
            int v2 = src.pop();
            if (v1 == f.apply(v1, v2)) {
               int tmp = v1;
                v1 = v2;
                v2 = tmp;
                result = true;
            }
            dest.push(v1);
            v1 = v2;
        }
        dest.push(v1);
        return result;
    }
}

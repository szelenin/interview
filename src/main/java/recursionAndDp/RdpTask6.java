package recursionAndDp;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by szelenin on 2/21/2016.
 */
public class RdpTask6 {
    public static void addParen(ArrayList<String> list, int leftRem,
                                int rightRem, char[] str, int count) {
        if (leftRem < 0 || rightRem < leftRem) return; // invalid state
        if (leftRem == 0 && rightRem == 0) { /* no more parens left */
            String s = String.copyValueOf(str);
            list.add(s);
        } else {
             /* Add left paren, if there are any left parens remaining. */
            if (leftRem > 0) {
                str[count] = '(';
                addParen(list, leftRem - 1, rightRem, str, count + 1);
            }

            /* Add right paren., if expression is valid */
            if (rightRem > leftRem) {
                str[count] = ')';
                addParen(list, leftRem, rightRem - 1, str, count + 1);
            }
        }
    }

    public static void addParent(List<String> result, char[] str, int leftRem, int rightRem, int idx, int retPoint) {
        System.out.println("current:" + new Frame(leftRem, rightRem, idx, retPoint));
        if (leftRem == 0 && rightRem == 0) {
            result.add(String.copyValueOf(str));
            return;
        }
        if (leftRem > 0) {
            str[idx] = '(';
            System.out.println("stack  :" + new Frame(leftRem, rightRem, idx, 1));
            addParent(result, str, leftRem - 1, rightRem, idx + 1, 1);
        }
        if (rightRem > leftRem) {
            str[idx] = ')';
            System.out.println("stack:  " + new Frame(leftRem, rightRem, idx, 2));
            addParent(result, str, leftRem, rightRem - 1, idx + 1, 2);
        }
        System.out.println("end");
    }

    private static class Frame {
        int leftRem;
        int rightRem;
        int idx;
        int retPoint;

        public Frame(int leftRem, int rightRem, int idx, int retPoint) {
            this.leftRem = leftRem;
            this.rightRem = rightRem;
            this.idx = idx;
            this.retPoint = retPoint;
        }

        @Override
        public String toString() {
            return "Frame{" +
                    "leftRem=" + leftRem +
                    ", rightRem=" + rightRem +
                    ", idx=" + idx +
                    ", retPoint=" + retPoint +
                    '}';
        }
    }

    public static void addParentIter(List<String> result, char[] str, int leftRem, int rightRem, int idx, int count) {
        Stack<Frame> stack = new Stack<>();
        Frame frame = new Frame(leftRem, rightRem, idx, 0);
        stack.push(frame);
        leftRem = frame.leftRem;
        rightRem = frame.rightRem;
        idx = frame.idx;
        while (!stack.isEmpty() ) {
            System.out.println("current:"+new Frame(leftRem, rightRem, idx, frame.retPoint));
            if (leftRem == 0 && rightRem == 0) {
                result.add(String.copyValueOf(str));
                frame = stack.pop();
                leftRem = frame.leftRem;
                rightRem = frame.rightRem;
                idx = frame.idx;
                continue;
            }
            if (leftRem > 0 && frame.retPoint < 1) {
                str[idx] = '(';
                System.out.println("stack  :"+new Frame(leftRem, rightRem, idx, 1));
                stack.push(new Frame(leftRem, rightRem, idx, 1));
                leftRem --;
                idx ++;
                continue;
//                addParent(result, str, leftRem - 1, rightRem, idx + 1);
            }
            if (rightRem > leftRem && frame.retPoint < 2) {
                str[idx] = ')';
                System.out.println("stack  :"+new Frame(leftRem, rightRem, idx, 2));
                stack.push(new Frame(leftRem, rightRem, idx, 2));
//            addParent(result, str, leftRem, rightRem - 1, idx + 1);
                rightRem--;
                idx++;
                continue;
            }
            System.out.println("end");
            frame = stack.pop();
            leftRem = frame.leftRem;
            rightRem = frame.rightRem;
            idx = frame.idx;
        }

    }

/*
    public static List<String> addParentIter(int count) {
        Stack stack = new Stack();
        int leftRem = count, rightRem = count;
        int idx = 0;
        char[] str = new char[count * 2];
        int rp = 0;
        ArrayList<String> result = new ArrayList<>();

        do {
            if (leftRem == 0 && rightRem == 0) {
                result.add(new String(str));
                rp = (int) stack.pop();
                leftRem = (int) stack.pop();
                rightRem = (int) stack.pop();
                idx = (int) stack.pop();
                System.out.println("l&r=0, idx = " + idx + ", str = " + new String(str));
                continue;
            }

            if (leftRem > 0 && rp == 0) {
                str[idx] = '(';
                stack.push(idx);
                stack.push(rightRem);
                stack.push(leftRem);
                stack.push(1);
                idx++;
                leftRem--;
                System.out.println("l>0, idx = " + idx + ", l = " + leftRem + ", r = " + rightRem + ", str = " + new String(str));
                continue;
            }
            if (rightRem > leftRem && (rp ==1 || rp == 0)) {
                str[idx] = ')';
                stack.push(idx);
                stack.push(rightRem);
                stack.push(leftRem);
                stack.push(2);
                rightRem--;
                idx++;
                System.out.println("l>0, idx = " + idx + ", l = " + leftRem + ", r = " + rightRem + ", str = " + new String(str));
                continue;
            }
            rp = (int) stack.pop();
            leftRem = (int) stack.pop();
            rightRem = (int) stack.pop();
            idx = (int) stack.pop();

        } while (!stack.isEmpty());
        return result;

    }
*/

    public static List<String> addParent(int count) {
        ArrayList<String> result = new ArrayList<>();
//        addParentIter(result, new char[count * 2], count, count, 0, count);
        addParentIter(result, new char[count * 2], count, count, 0, 0);
        return result;
//        return addParentIter(count);
    }
}

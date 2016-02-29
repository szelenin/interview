package recursionAndDp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by szelenin on 2/29/2016.
 */
public class RdpTask10 {

    public static class Box {
        public final int w;
        public final int h;
        public final int d;

        public Box(int w, int h, int d) {
            this.w = w;
            this.h = h;
            this.d = d;
        }

        @Override
        public String toString() {
            return "(" +
                    "w=" + w +
                    ", h=" + h +
                    ", d=" + d +
                    ')';
        }
    }

    public static List<Box> stack(List<Box> boxes) {
        Collections.sort(boxes, (box1, box2) -> box2.h - box1.h);
        List<List<Box>> stacks = new ArrayList<>(boxes.size());
        stacks.add(Collections.singletonList(boxes.get(0)));
        for (int i = 1; i < boxes.size(); i++) {
            Box currentBox = boxes.get(i);
            LinkedList<Box> currentStack = new LinkedList<>();
            currentStack.add(currentBox);
            for (int j = 0; j < i; j++) {
                LinkedList<Box> potentialStack = new LinkedList<>(stacks.get(j));
                if (canPut(currentBox, potentialStack)) {
                    potentialStack.addLast(currentBox);
                    if (height(potentialStack) > height(currentStack)) {
                        currentStack = potentialStack;
                    }
                }
            }
            stacks.add(currentStack);
        }
        return stacks.get(stacks.size() - 1);
    }

    private static int height(LinkedList<Box> stack) {
        return stack.stream().collect(Collectors.summingInt(box -> box.h));
    }

    private static boolean canPut(Box box, LinkedList<Box> stack) {
        Box last = stack.getLast();
        return last.h > box.h && last.w > box.w && last.d > box.d;
    }
}

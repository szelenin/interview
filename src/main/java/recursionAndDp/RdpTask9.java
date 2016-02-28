package recursionAndDp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by szelenin on 2/29/2016.
 */
public class RdpTask9 {
    public static class Point{
        public final int x;
        public final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }

    public static List<List<Point>> queensPos() {
        return queensPos(0, new ArrayList());
    }

    private static List<List<Point>> queensPos(int y, List<Point> queens) {
        if (y == 8) {
            return Collections.singletonList(queens);
        }
        boolean available[] = available(y, queens);
        List<List<Point>> result = new ArrayList<>();
        for (int x = 0; x < 8; x++) {
            if (!available[x]) {
                continue;
            }
            List<Point> newQueens = new ArrayList<>(queens);
            newQueens.add(new Point(x, y));
            result.addAll(queensPos(y + 1, newQueens));
        }
        return result;
    }

    private static boolean[] available(int y, List<Point> queens) {
        boolean[] available = new boolean[8];
        Arrays.fill(available, 0, available.length, true);
        for (int i = 0; i<queens.size();i++) {
            Point queen = queens.get(i);
            available[queen.x] = false;

            int diff = y - i;
            if (queen.x + diff < 8) {
                available[queen.x + diff] = false;
            }
            if (queen.x - diff >= 0) {
                available[queen.x - diff] = false;
            }
        }
        return available;
    }
}

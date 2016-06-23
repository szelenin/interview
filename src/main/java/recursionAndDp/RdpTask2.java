package recursionAndDp;


import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by szelenin on 2/14/2016.
 */
public class RdpTask2 {
    public static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "[" + x + "," + y + "]";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (x != point.x) return false;
            return y == point.y;

        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

    public static int countPaths(int x, int y) {
        if (x == 0 && y == 0) {
            return 1;
        }
        if (x < 0 || y < 0) {
            return 0;
        }
        return countPaths(x - 1, y) + countPaths(x, y - 1);
    }

    public static List<Point> path(int x, int y, boolean[][] spots) {
        if (x == 0 && y == 0) {
            LinkedList<Point> result = new LinkedList<>();
            result.add(new Point(x, y));
            return result;
        }
        if (x < 0 || y < 0 || spots[x][y]) {
            return null;
        }
        List<Point> pathX = path(x - 1, y, spots);
        if (pathX != null) {
            return createPath(x, y, pathX);
        }
        List<Point> pathY = path( x, y - 1, spots);
        if (pathY != null) {
            return createPath(x, y, pathY);
        }
        return null;
    }

    private static List<Point> createPath(int x, int y, List<Point> partialPath) {
        LinkedList<Point> path = new LinkedList<>(partialPath);
        path.add(new Point(x, y));
        return path;
    }
}

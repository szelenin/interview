package recursionAndDp;

/**
 * Created by szelenin on 2/14/2016.
 */
public class RdpTask2 {
    public static int countPaths(int x, int y) {
        if (x == 0 && y == 0) {
            return 1;
        }
        if (x < 0 || y < 0) {
            return 0;
        }
        return countPaths(x - 1, y) + countPaths(x, y - 1);
    }
}

package recursionAndDp;

/**
 * Created by szelenin on 2/27/2016.
 */
public class RdpTask7 {
    public static void fill(int[][] a, int color, int x, int y) {
        int originalColor = a[y][x];
        fillSpot(a, color, originalColor, x, y);
    }

    private static void fillSpot(int[][] a, int color, int originalColor, int x, int y) {
        if (y < 0 || x < 0 || y >= a.length || x >= a[0].length) {
            return;
        }
        if (a[y][x] == originalColor) {
            a[y][x] = color;
            fillSpot(a, color, originalColor, x + 1, y);
            fillSpot(a, color, originalColor, x - 1, y);
            fillSpot(a, color, originalColor, x, y + 1);
            fillSpot(a, color, originalColor, x, y - 1);
        }
    }
}

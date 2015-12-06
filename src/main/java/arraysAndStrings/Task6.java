package arraysAndStrings;

/**
 * Created by szelenin on 12/5/2015.
 */
public class Task6 {
    public static int[][] rotate(int[][] image) {
        for (int j = 0; j < image.length / 2; j++) {
            rotateLine(j, image);
        }
        return image;
    }

    private static void rotateLine(int j, int[][] image) {
        int n = image.length;
        for (int i = j; i < n - 1 - j; i++) {
            int ul = image[j][i];
            int ur = image[i][n-1-j];
            int lr = image[n-1-j][n-1-j-i];
            int ll = image[n-1-j-i][j];
            image[j][i]=ll;
            image[i][n-1-j]=ul;
            image[n-1-j][n-1-j-i]=ur;
            image[n-1-j-i][j]=lr;
        }

    }
}


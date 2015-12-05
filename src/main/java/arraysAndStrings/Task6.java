package arraysAndStrings;

/**
 * Created by szelenin on 12/5/2015.
 */
public class Task6 {
    public static int[][] rotate(int[][] image){
        int n = image.length;
        for (int i = 0;i<n/2;i++){
            int upperLeftPixel = image[i][i];
            int upperRightPixel = image[i][n-i-1];
            int lowerRightPixel = image[n-i-1][n-i-1];
            int lowerLeftPixel = image[n-i-1][i];
            image[i][i] =  lowerLeftPixel;
            image[i][n-i-1] = upperLeftPixel;
            image[n-i-1][n-i-1] = upperRightPixel;
            image[n-i-1][i] = lowerRightPixel;
        }
        return image;
    }
}


package other;

/**
 * Created by Sergii_Zelenin on 5/23/2016.
 * https://www.youtube.com/watch?v=FPDnwp9OLns
 */
public class FromGuy41 {


    //1,2,3,4,5
    // i = 0: 1,2,3,4,5 tmp = 2; 2,1,3,4,5;
    // i = 1: 2,1,3,4,5 tmp = 3; 3,1,2,4,5
    // i = 2: 2,1,3,4,5 tmp = 4; 4,1,2,3,5
    // i = 3: 2,1,3,4,5 tmp = 5; 5,1,2,3,4
    public static int[] rotate(int[] array, int count) {
        for (int k = 0; k < count % array.length; k++) {
            for (int i = 0; i < array.length - 1; i++) {
                int tmp = array[i + 1];
                array[i + 1] = array[0];
                array[0] = tmp;
            }
        }
        return array;
    }
}

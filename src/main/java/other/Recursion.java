package other;

/**
 * Created by szelenin on 2/23/2016.
 */
public class Recursion {
    public static int factorial(int n, int acc) {
        while (true) {
            if (n < 2) {
                return n * acc;
            }
            acc = acc * n;
            n = n - 1;
        }
    }
}

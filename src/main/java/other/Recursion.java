package other;

/**
 * Created by szelenin on 2/23/2016.
 */
public class Recursion {
    public static int factorial(int n, int acc) {
        if (n < 2) {
            return n * acc;
        }
        return factorial(n - 1, n * acc);
    }
}

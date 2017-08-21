package other;

/**
 * Created by Sergii_Zelenin on 8/21/2017.
 */
public class GCD {
    public static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (a > b) {
            return gcd(a % b, b);
        }
        return gcd(b % a, a);
    }
}

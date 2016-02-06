package bitManipulation;

/**
 * Created by szelenin on 2/6/2016.
 */
public class BmTask5 {
    public static int numBits(int a, int b) {
        int result = 0;
        while (a > 0 || b > 0) {
            result += (a & 1) ^ (b & 1);
            a >>= 1;
            b >>= 1;
        }
        return result;
    }

    public static int numBitsBook(int a, int b) {
        int count = 0;
        for (int x = a ^ b; x > 0; x >>= 1) {
            count += x & 1;
        }
        return count;
    }

    public static int numBitsBook2(int a, int b) {
        int count = 0;
        for (int x = a ^ b; x > 0; x &= x - 1) {
            count++;
        }
        return count;
    }
}

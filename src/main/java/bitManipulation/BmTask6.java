package bitManipulation;

/**
 * Created by szelenin on 2/6/2016.
 */
public class BmTask6 {
    public static int swapBits(int a) {
        int oddMask = 0xaaaa;
        return a >> 1 & ~oddMask |a << 1 & oddMask;
    }
}

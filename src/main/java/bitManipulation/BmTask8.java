package bitManipulation;

/**
 * Created by szelenin on 2/7/2016.
 */
public class BmTask8 {
    public static byte[] drawLine(int x1, int x2, int y, int w, byte[] a) {
        int h = a.length / w;
        if (y > h - 1) {
            y = h - 1;
        }
        if (x1 > x2) {
            int tmp = x1;
            x1=x2;
            x2 = tmp;
        }
        if (x1 > w * 8 - 1) {
            x1 = w * 8 - 1;
        }
        if (x2 > w * 8 - 1) {
            x2 = w * 8 - 1;
        }
        int lineLength = x2 - x1 + 1;
        int startBit = x1 % 8;
        int currentIdx = w * y + x1 / 8;
        while (lineLength > 0) {
            int bitLen = startBit + lineLength > 8 ? 8 - startBit : lineLength;
            a[currentIdx] = drawPx(a[currentIdx], startBit, bitLen);
            currentIdx++;
            lineLength-=bitLen;
            startBit = 0;
        }
        return a;
    }

    private static byte drawPx(byte a, int startBit, int len) {
        return (byte) (a | 0xff >> startBit & 0xff << (8 - len - startBit));
    }
}

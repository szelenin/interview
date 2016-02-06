package bitManipulation;

/**
 * Created by szelenin on 2/6/2016.
 */
public class BmTask2 {
    public static String printBinary(double v) {
        double precision = 1.0 / (((long) Math.pow(2, 32)) - 1);
        double current = 0;
        double div = 1;
        StringBuilder sb = new StringBuilder();
        while (Math.abs(v - current) > precision) {
            div = div / 2;
            if (div > v - current) {
                sb.append("0");
            } else {
                sb.append("1");
                current += div;
            }
        }
        return sb.toString();
    }
}

package other;

/**
 * Created by szelenin on 3/7/2016.
 */
public class PowerOf3 {
    public static double powerOf3(int value) {
        int power = 0;
        for (int current = value / 3; current > 0; current /= 3) {
            power++;
        }
        double vDivided = ((double) value) / Math.pow(3, power);
        double min = 0.000001;
        double max = 0.999999;
        double x;
        double diff;
        do {
            x = (max + min) / 2;
            diff = Math.pow(3, x) - vDivided;
            if (diff > 0) {
                max = x;
            } else {
                min = x;
            }
        } while (Math.abs(diff) > 0.0001);

        return power + x;

    }
}

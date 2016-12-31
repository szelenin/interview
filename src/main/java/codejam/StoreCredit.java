package codejam;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Sergii_Zelenin on 12/30/2016.
 */
public class StoreCredit {
    public static void main(String[] args) throws IOException {
        runSolutions(System.in, System.out);
    }

    public static void runSolutions(InputStream in, PrintStream out) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String nStr = reader.readLine();
        Integer n = Integer.parseInt(nStr.trim());
        for (int i = 0; i < n; i++) {
            int credit = Integer.parseInt(reader.readLine().trim());
            int l = Integer.parseInt(reader.readLine().trim());
            int[] items = new int[l];
            String line = reader.readLine();
            String[] itemsStr = line.split(" ");
            for (int j = 0; j < itemsStr.length; j++) {
                String s = itemsStr[j];
                items[j] = Integer.parseInt(s);
            }
            int[] result = solve(credit, items);
            out.println("Case #" + (i + 1) + ": " + result[0] + " " + result[1]);
        }
        out.flush();
    }

    //return int array of size 2
    public static int[] solve(int credit, int[] items) {
        //stupid solution with double iteration
        for (int i = 0; i < items.length; i++) {
            for (int j = i + 1; j < items.length; j++) {
                if (items[i] + items[j] == credit) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }
        return new int[]{-1, -1};
    }
}

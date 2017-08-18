package other;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by Sergii_Zelenin on 8/17/2017.
 */
public class MergeSort {
    public static int[] sort(int[] a) {
        mergeSort(a, 0, a.length - 1);
        return a;
    }

    //start, end inclusive
    private static void mergeSort(int[] a, int start, int end) {
        if (start == end) {
            return;
        }
        int m = (start + end) / 2;
        mergeSort(a, start, m);
        mergeSort(a, m + 1, end);
        merge(a, start, m + 1, end);
    }

    private static void merge(int[] a, int start, int m, int end) {
        int[] b = new int[end - start + 1];
        System.arraycopy(a, start, b, 0, end - start + 1);
        //k from start to end inclusive - a
        //i from start to m : projection to b
        //j from m+1 to end projection to b
        int i = 0;
        int j = end - start;
        for (int k = start; k <= end; k++) {
            if (i > m) {
                a[k] = b[j++];
                continue;
            }
            if (j > end) {
                a[k] = b[i++];
                continue;
            }
            if (b[i] < b[j]) {
                a[k] = b[i++];
            }else{
                a[k] = b[j++];
            }
        }
    }

    public static void splitMerge(int[] a, int[] b, int start, int end) {
        int m = (start + end) / 2;
        if (m == start) {
            return;
        }
        splitMerge(a, b, start, m);
        splitMerge(a, b, m + 1, end);

        //merge
        int i = start; //i : start..m
        int j = m; //j:m..end
        for (int k = start; k < end; k++) {
            if (i >= m) {
                b[k] = a[j++];
                continue;
            }
            if (j >= end) {
                b[k] = a[i++];
                continue;
            }

            if (a[i] < a[j]) {
                b[k] = a[i++];
                continue;
            }

            if (a[j] < a[i]) {
                b[k] = a[j++];
            }
        }

        System.arraycopy(b, start, a, start, end - start);
    }

}

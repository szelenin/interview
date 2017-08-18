package other;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Sergii_Zelenin on 8/17/2017.
 */
public class MergeSortTest {
    @Test
    public void test1(){
        verifyMergeSort(new int[]{4, 7, 3}, new int[]{3, 4, 7});
    }

    @Test
    public void test2(){
        verifyMergeSort(new int[]{1}, new int[]{1});
    }

    @Test
    public void test3(){
        verifyMergeSort(new int[]{2, 1}, new int[]{1, 2});
    }

    @Test
    public void test4(){
        verifyMergeSort(new int[]{2, 1, -2}, new int[]{-2, 1, 2});
    }

    private void verifyMergeSort(int[] a, int[] expected) {
        MergeSort.sort(a);
        Assert.assertArrayEquals(a, expected);
    }

}
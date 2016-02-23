package other;

import org.junit.Test;
import treesAndGraphs.TreeNode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by szelenin on 2/23/2016.
 */
public class RecursionTest {
    @Test
    public void shouldFactorial() {
        assertEquals(120, Recursion.factorial(5, 1));
    }

    @Test
    public void shouldfind_val_or_next_smallest() {
        TreeNode tree0 = null;
        TreeNode tree1 = new TreeNode(5);
        TreeNode tree2 = new TreeNode(new TreeNode(3), null, "5");
        TreeNode tree3 = new TreeNode(new TreeNode(3), new TreeNode(9), "5");
        TreeNode tree4 = new TreeNode(new TreeNode(new TreeNode(1), null, "3"), new TreeNode(9), "5");

        TreeNode[] trees = new TreeNode[]{tree0, tree1, tree2, tree3, tree4};
        List<List<Integer>> tree_vals = Arrays.asList(
                Arrays.asList(), Arrays.<Integer>asList(5), Arrays.<Integer>asList(3, 5), Arrays.<Integer>asList(3, 5, 9), Arrays.<Integer>asList(1, 3, 5, 9));
        for (int i = 0; i < trees.length; i++) {
            for (int x = 0; x <= 10; x++) {
                Integer y = Recursion.find_val_or_next_smallest(trees[i], x, null);
                int[] xArr = {x};
                if (y == null) {
                    assert tree_vals.get(i).stream().allMatch((z) -> xArr[0] < z);
                } else {
                    assert y <= x;
                    if (y != x) {
                        int pos = Collections.binarySearch(tree_vals.get(i), x);
                        assert tree_vals.get(i).subList(pos < 0 ? tree_vals.get(i).size() : pos, tree_vals.get(i).size()).stream().allMatch((z) -> xArr[0] < z);
                    }
                }
            }
        }
    }

}
package other;

import treesAndGraphs.TreeNode;

/**
 * Created by szelenin on 2/23/2016.
 */
public class Recursion {
    public static int factorial(int n, int acc) {
        while (true) {
            if (n < 2) {
                return n * acc;
            }
            acc = acc * n;
            n = n - 1;
        }
    }

    public static Integer find_val_or_next_smallest(TreeNode bst, int x) {
        //Get the greatest value <= x in a binary search tree.
        //Returns None if no such value can be found.
        Integer right_best = null;
        while (true) {

            if (bst == null) {
                return right_best;
            }
            if (bst.value() == x) {
                return x;
            }
            if (bst.value() > x) {
                bst = bst.left;
            } else {
                right_best = right_best == null ? bst.value() : right_best;
                bst = bst.right;
            }
        }
    }

}
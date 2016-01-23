package treesAndGraphs;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by szelenin on 1/23/2016.
 */
public class Task5Test {
    @Test
    public void should(){
        TreeNode left = new TreeNode(null, new TreeNode(null, null, "25"), "10");
        TreeNode right = new TreeNode(null, null, "30");
        TreeNode root = new TreeNode(left, right, "20");

        assertFalse(Task5.isBst(root));
    }

}
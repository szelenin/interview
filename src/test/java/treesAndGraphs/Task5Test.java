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

    @Test
    public void should2(){
        TreeNode five = new TreeNode(new TreeNode(3), new TreeNode(7), "5");
        TreeNode fifteen = new TreeNode(null, new TreeNode(17), "15");
        TreeNode ten = new TreeNode(five, fifteen, "10");
        TreeNode root = new TreeNode(ten, new TreeNode(30), "20");
        assertTrue(Task5.isBst(root));
    }

    @Test
    public void should3(){
        assertFalse(Task5.isBst(new TreeNode(null, new TreeNode(null, null, "20"), "20")));
    }
}
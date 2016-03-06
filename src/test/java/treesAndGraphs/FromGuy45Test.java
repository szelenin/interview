package treesAndGraphs;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by szelenin on 3/6/2016.
 */
public class FromGuy45Test {
    @Test
    public void should(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        assertEquals("1234675", FromGuy45.counterClockwiseOrder(root));
    }
    @Test
    public void should2(){
        TreeNode root = new TreeNode(1); // level 0
        root.left = new TreeNode(2); // level 1
        root.left.left = new TreeNode(3); // level 2
        root.left.right = new TreeNode(4); // level 2 - skip
        root.left.left.left = new TreeNode(7); // level 3
        root.left.left.right = new TreeNode(8);// level 3
        root.left.right.left = new TreeNode(5); //level 3
        root.left.right.right = new TreeNode(6); // level 3
        root.right = new TreeNode(9); // level 1
        root.right.left = new TreeNode(10); // level 2
        root.right.right = new TreeNode(11);// level 2
        root.right.left.left = new TreeNode(12);// level 3
        root.right.left.right = new TreeNode(13);// level 3

        assertEquals("12378561213119", FromGuy45.counterClockwiseOrder(root));
    }

}
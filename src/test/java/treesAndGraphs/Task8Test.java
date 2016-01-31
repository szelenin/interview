package treesAndGraphs;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by szelenin on 1/31/2016.
 */
public class Task8Test {
    @Test
    public void shouldMySolution(){
        TreeNode four = new TreeNode(4);
        TreeNode seven = new TreeNode(7);
        TreeNode three = new TreeNode(seven, four, "3");
        TreeNode two = new TreeNode(three, null, "2");
        TreeNode five = new TreeNode(5);
        TreeNode one = new TreeNode(two, five, "1");

        assertTrue(Task8.isSubtree(one, three));
        assertTrue(Task8.isSubtree(one, new TreeNode(new TreeNode(7), new TreeNode(4), "3")));
        assertFalse(Task8.isSubtree(one, new TreeNode(new TreeNode(4), new TreeNode(7), "3")));
    }

}
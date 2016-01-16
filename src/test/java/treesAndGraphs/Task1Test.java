package treesAndGraphs;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by szelenin on 1/16/2016.
 */
public class Task1Test {
    @Test
    public void should(){
        assertTrue(Task1.isBalanced(null).balanced);
        assertTrue(Task1.isBalanced(new TreeNode(new TreeNode(null, null, "1"), null, "0")).balanced);
        assertTrue(Task1.isBalanced(new TreeNode(null, new TreeNode(null, null, "1"), "0")).balanced);
        assertTrue(Task1.isBalanced(new TreeNode(new TreeNode(null, null, "2"), new TreeNode(null, null, "1"), "0")).balanced);
        assertFalse(Task1.isBalanced(new TreeNode(new TreeNode(new TreeNode(null, null, "1"), null, "2"), null, "0")).balanced);
    }

    @Test
    public void should2(){
        TreeNode d = new TreeNode(null, null, "D");
        TreeNode c = new TreeNode(d, null, "C");
        TreeNode b = new TreeNode(c, null, "B");
        TreeNode g = new TreeNode(null, null, "G");
        TreeNode f = new TreeNode(null, g, "F");
        TreeNode e = new TreeNode(null, f, "E");
        TreeNode a = new TreeNode(b, e, "A");

        assertFalse(Task1.isBalanced(a).balanced);
    }
}
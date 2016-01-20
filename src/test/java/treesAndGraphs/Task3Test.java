package treesAndGraphs;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by szelenin on 1/20/2016.
 */
public class Task3Test {
    @Test
    public void should(){
        assertEquals("1", inOrder(Task3.buildTree(new int[]{1})));
        assertTrue(Task1.isBalanced(Task3.buildTree(new int[]{1})).balanced);
        assertEquals("12", inOrder(Task3.buildTree(new int[]{1,2})));
        assertTrue(Task1.isBalanced(Task3.buildTree(new int[]{1,2})).balanced);
        assertEquals("123", inOrder(Task3.buildTree(new int[]{1,2,3})));
        assertTrue(Task1.isBalanced(Task3.buildTree(new int[]{1,2,3})).balanced);
        assertEquals(2, Task1.isBalanced(Task3.buildTree(new int[]{1,2,3})).height);
        assertEquals("12345", inOrder(Task3.buildTree(new int[]{1,2,3,4,5})));
        assertTrue(Task1.isBalanced(Task3.buildTree(new int[]{1,2,3,4,5})).balanced);
        assertEquals(3, Task1.isBalanced(Task3.buildTree(new int[]{1,2,3,4,5})).height);
        assertEquals("1234", inOrder(Task3.buildTree(new int[]{1,2,3,4})));
        assertTrue(Task1.isBalanced(Task3.buildTree(new int[]{1,2,3,4})).balanced);
        assertEquals(3, Task1.isBalanced(Task3.buildTree(new int[]{1,2,3,4})).height);
        assertTrue(Task1.isBalanced(Task3.buildTree(new int[]{1,2,3,4,5,6,7,8})).balanced);
    }

    private String inOrder(TreeNode root) {
        TreeTraverse treeTraverse = new TreeTraverse();
        treeTraverse.inOrder(root);
        return treeTraverse.path;
    }
}
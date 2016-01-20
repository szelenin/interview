package treesAndGraphs;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by szelenin on 1/20/2016.
 */
public class Task3Test {
    @Test
    public void should(){
//        assertEquals("1", inOrder(Task3.buildTree(new int[]{1})));
//        assertEquals("12", inOrder(Task3.buildTree(new int[]{1,2})));
        assertEquals("123", inOrder(Task3.buildTree(new int[]{1,2,3})));
    }

    private String inOrder(TreeNode root) {
        TreeTraverse treeTraverse = new TreeTraverse();
        treeTraverse.inOrder(root);
        return treeTraverse.path;
    }
}
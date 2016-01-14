package treesAndGraphs;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by szelenin on 1/14/2016.
 */
public class TreeTraverseTest {

    private TreeNode root;

    @Before
    public void setUp() {
        TreeNode c = new TreeNode(null, null, "C");
        TreeNode e = new TreeNode(null, null, "E");
        TreeNode d = new TreeNode(c, e, "D");
        TreeNode a = new TreeNode(null, null, "A");
        TreeNode b = new TreeNode(a, d, "B");
        TreeNode h = new TreeNode(null, null, "H");
        TreeNode i = new TreeNode(h, null, "I");
        TreeNode g = new TreeNode(null, i, "G");
        root = new TreeNode(b, g, "F");
    }

    @Test
    public void shouldPreOrder() {
        TreeTraverse treeTraverse = new TreeTraverse();
        treeTraverse.preOrder(root);
        assertEquals("FBADCEGIH", treeTraverse.path);
    }

    @Test
    public void shouldInOrder() {
        TreeTraverse treeTraverse = new TreeTraverse();
        treeTraverse.inOrder(root);
        assertEquals("ABCDEFGHI", treeTraverse.path);
    }

    @Test
    public void shouldPostOrder() {
        TreeTraverse treeTraverse = new TreeTraverse();
        treeTraverse.postOrder(root);
        assertEquals("ACEDBHIGF", treeTraverse.path);
    }
}
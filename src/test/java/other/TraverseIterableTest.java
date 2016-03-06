package other;

import org.junit.Before;
import org.junit.Test;
import treesAndGraphs.TreeNode;
import treesAndGraphs.TreeTraverse;

import static org.junit.Assert.*;

/**
 * Created by szelenin on 2/24/2016.
 */
public class TraverseIterableTest {
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
        TraverseIterable treeTraverse = new TraverseIterable();
        treeTraverse.preOrder(root);
        assertEquals("FBADCEGIH", treeTraverse.path);
    }

    @Test
    public void shouldInOrder() {
        TraverseIterable treeTraverse = new TraverseIterable();
        treeTraverse.inOrder(root);
        assertEquals("ABCDEFGHI", treeTraverse.path);
    }

}
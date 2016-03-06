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
        assertEquals("FBADCEGIH", treeTraverse.preOrderIter(root));
    }

    @Test
    public void shouldInOrder() {
        TraverseIterable treeTraverse = new TraverseIterable();
        assertEquals("ABCDEFGHI", treeTraverse.inorderIter(root));
    }

    @Test
    public void shouldInOrder2() {
        TraverseIterable treeTraverse = new TraverseIterable();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left  = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);
        root.right = new TreeNode(3);

        assertEquals("425613", treeTraverse.inorderIter(root));
    }

    @Test
    public void shouldPostOrder() {
        TraverseIterable treeTraverse = new TraverseIterable();
        assertEquals("ACEDBHIGF", treeTraverse.postOrderIter(root));
    }

}
package recursionAndDp;

import org.junit.Test;
import other.TraverseIterable;
import treesAndGraphs.TreeNode;
import treesAndGraphs.TreeTraverse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by szelenin on 3/7/2016.
 */
public class FromGuy44Test {
    @Test
    public void shouldBuildTrees() {
        String[] preorders = "1,2".split("\\,");
        assertEquals(2, FromGuy44.buildTrees(preorders).size());
    }

    @Test
    public void shouldBuildTrees2() {
        String[] preorders = "1,2,3".split("\\,");
        List<TreeNode> treeNodes = buildTrees2(preorders);
        for (TreeNode root : treeNodes) {
            String path = new TraverseIterable().inorderIter(root);
            System.out.println("path = " + path);
        }
        assertEquals(5, treeNodes.size());
    }

    //1,2,3
    //rootIdx
    //leftEnd
    //rightEnd
    private List<TreeNode> buildTrees2(String[] preorders) {
        return buildTrees2(0, 0, preorders.length - 1, preorders);
    }
//1,2,3,4 1: root, null-234;2-34;23-4;234-null;
//
    private List<TreeNode> buildTrees2(int rootIdx, int leftEnd, int rightEnd, String[] preorders) {
        ArrayList<TreeNode> result = new ArrayList<>();
        if (rootIdx == leftEnd && rootIdx == rightEnd) {
            result.add(new TreeNode(null, null, preorders[rootIdx]));
        }
        if (leftEnd > rightEnd || rootIdx > rightEnd) {
            return Collections.singletonList(null);
        }

        for (int i = leftEnd; i <= rightEnd; i++) {
            List<TreeNode> lefts = buildTrees2(rootIdx + 1, rootIdx + 1, i, preorders);
            List<TreeNode> rights = buildTrees2(i + 1, i + 1, rightEnd, preorders);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    result.add(new TreeNode(left, right, preorders[rootIdx]));
                }
            }
        }
        return result;
    }

}
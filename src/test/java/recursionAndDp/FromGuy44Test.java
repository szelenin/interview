package recursionAndDp;

import org.junit.Test;
import other.TraverseIterable;
import treesAndGraphs.TreeNode;
import treesAndGraphs.TreeTraverse;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by szelenin on 3/7/2016.
 */
public class FromGuy44Test {
    @Test
    public void shouldBuildTrees(){
        String[] preorders = "1,2".split("\\,");
        assertEquals(2, FromGuy44.buildTrees(preorders).size());
    }

    @Test
    public void shouldBuildTrees2(){
        String[] preorders = "1,2,3".split("\\,");
        List<TreeNode> treeNodes = FromGuy44.buildTrees(preorders);
        for (TreeNode root : treeNodes) {
            String path = new TraverseIterable().inorderIter(root);
            System.out.println("path = " + path);
        }
        assertEquals(2, treeNodes.size());
    }

}
package recursionAndDp;

import treesAndGraphs.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by szelenin on 3/6/2016.
 */
public class FromGuy44 {

    public static List<TreeNode> buildTrees(String[] preorders) {
        return buildTrees(0, 0, preorders.length - 1, preorders);
    }

    private static List<TreeNode> buildTrees(int rootIdx, int leftEnd, int rightEnd, String[] preorders) {
        if (rootIdx == leftEnd && rootIdx == rightEnd) {
            return Collections.singletonList(new TreeNode(null, null, preorders[rootIdx]));
        }
        if (leftEnd > rightEnd || rootIdx > rightEnd) {
            return Collections.singletonList(null);
        }
        List<TreeNode> result = new ArrayList<>();
        for (int i = leftEnd; i <= rightEnd; i++) {
            List<TreeNode> lefts = buildTrees(rootIdx + 1, rootIdx + 1, i, preorders);
            List<TreeNode> rights = buildTrees(i + 1, i + 1, rightEnd, preorders);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    result.add(new TreeNode(left, right, preorders[rootIdx]));
                }
            }
        }
        return result;
    }
}

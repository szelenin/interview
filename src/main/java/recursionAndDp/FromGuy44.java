package recursionAndDp;

import treesAndGraphs.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by szelenin on 3/6/2016.
 */
public class FromGuy44 {
/*
    public static List<String> allPossibleInOrders(String preOrder) {
        String[] preorders = preOrder.split("\\,");

        List<TreeNode> trees = new ArrayList<>();
        for (int i = 0; i < preorders.length; i++) {
            trees.add(buildTree(i, i + 1, preorders));
        }

    }
*/

    public static List<TreeNode> buildTrees(String[] preorders) {
        return buildTrees(0, 0, preorders.length - 1, preorders);
    }

    private static List<TreeNode> buildTrees(int rootIdx, int leftEnd, int rightEnd, String[] preorders) {
        if (rootIdx == leftEnd && rootIdx == rightEnd) {
            return Collections.singletonList(new TreeNode(null, null, preorders[rootIdx]));
        }
        List<TreeNode> lefts;
        if (rootIdx == leftEnd) {
            lefts = Collections.singletonList(null);
        } else {
            lefts = buildTrees(rootIdx + 1, rootIdx + 1, leftEnd, preorders);
        }
        List<TreeNode> rights;
        if (leftEnd == rightEnd) {
            rights = Collections.singletonList(null);
        } else {
            rights = buildTrees(leftEnd + 1, leftEnd + 1, rightEnd, preorders);
        }
        List<TreeNode> result = new ArrayList<>();
        for (TreeNode left : lefts) {
            for (TreeNode right : rights) {
                result.add(new TreeNode(left, right, preorders[rootIdx]));
            }
        }
        for (int i = leftEnd + 1; i <= rightEnd; i++) {
            result.addAll(buildTrees(rootIdx, i, rightEnd, preorders));
        }
        return result;
    }
}

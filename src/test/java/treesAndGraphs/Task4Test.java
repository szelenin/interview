package treesAndGraphs;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by szelenin on 1/22/2016.
 */
public class Task4Test {
    @Test
    public void should() {
        TreeNode two = new TreeNode(new TreeNode(null, null, "6"), new TreeNode(null, null, "7"), "2");
        TreeNode three = new TreeNode(new TreeNode(null, null, "4"), new TreeNode(null, null, "5"), "3");
        TreeNode root = new TreeNode(two, three, "1");

        Map<Integer, List<String>> result = Task4.createList(root);

        assertEquals("[1]", result.get(0).toString());
        assertEquals("[2, 3]", result.get(1).toString());
        assertEquals("[6, 7, 4, 5]", result.get(2).toString());
    }
}
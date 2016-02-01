package treesAndGraphs;

import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by szelenin on 2/1/2016.
 */
public class Task9Test {

    @Test
    public void should() {
        TreeNode four = new TreeNode(new TreeNode(5), new TreeNode(100), "4");
        TreeNode two = new TreeNode(new TreeNode(3), four, "2");
        int[] branches = {1, 1, 2, 1, 1, 1, 1};
        TreeNode one = new TreeNode(two, build(branches, 0), "1");

        Set<String> paths = Task9.paths(one, 6);
        assertEquals(4, paths.size());
    }

    private TreeNode build(int[] branches, int index) {
        if (index == branches.length - 1) {
            return new TreeNode(branches[index]);
        }
        return new TreeNode(null, build(branches, index + 1), "" + branches[index]);
    }
}
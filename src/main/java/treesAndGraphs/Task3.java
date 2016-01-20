package treesAndGraphs;

/**
 * Created by szelenin on 1/20/2016.
 */
public class Task3 {
    public static TreeNode buildTree(int[] array) {
        int middle = middle(0, array.length - 1);
        return new TreeNode(
                buildTree(array, 0, middle - 1),
                buildTree(array, middle + 1, array.length - 1),
                ""+array[middle]);

    }

    private static TreeNode buildTree(int[] array, int start, int end) {
        if (end < start) {
            return null;
        }
        int middle = middle(start, end);
        return new TreeNode(
                buildTree(array, start, middle - 1),
                buildTree(array, middle + 1, end),
                "" + array[middle]);

    }

    private static int middle(int start, int end) {
        return (end + start) / 2 + (end + start) % 2;
    }
}

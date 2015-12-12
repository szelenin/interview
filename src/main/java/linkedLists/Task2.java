package linkedLists;

/**
 * Created by szelenin on 12/12/2015.
 */
public class Task2 {
    public static int iterate(Node node, int k, Result result){
        if (node == null){
            return 0;
        }
        int i = iterate(node.next, k, result);
        if (i == k) {
            result.node = node;
        }
        return i + 1;
    }

}

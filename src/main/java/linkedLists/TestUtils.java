package linkedLists;

/**
 * Created by szelenin on 12/12/2015.
 */
public class TestUtils {
    public static String listToString(Node node) {
        StringBuilder sb = new StringBuilder();
        Node current = node;
        while (current != null) {
            sb.append(current.data).append(" ");
            current = current.next;
        }
        return sb.toString();
    }
}

package linkedLists;

/**
 * Created by szelenin on 12/12/2015.
 */
public class Task5 {
    public static Node plus(Node xNode, Node yNode) {
        return plus(xNode, yNode, 0);
    }

    public static Node plus(Node xNode, Node yNode, int remaining){
        Node xNext = null, yNext = null;
        int x = 0, y = 0;
        if (xNode == null && yNode == null) return remaining > 0 ? new Node(remaining) : null;
        if (xNode != null){
            xNext = xNode.next;
            x = xNode.data;
        }
        if (yNode != null){
            yNext = yNode.next;
            y = yNode.data;
        }
        return new Node((x+y+remaining)%10, plus(xNext, yNext,  (x + y + remaining) / 10));
    }
}

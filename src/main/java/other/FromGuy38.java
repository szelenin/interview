package other;

import linkedLists.Node;

/**
 * Created by Sergii_Zelenin on 6/13/2016.
 */
public class FromGuy38 {
    private Node head;
    //TODO: FIx error with interweave: create new list
    public static Node interweave(Node head) {
        //1. find midle 1,2,3,4,5: 1,2,3 : 4,5
        //2. reverse 2nd list: 4,5:5,4
        //3. interweave 1,2,3,4 + 5,4 : 1,5,2,4,3
        Node middle = findMiddle(head);
        Node middleHead = reversePart(middle);
        return interweave(head, middleHead);
    }

    private static Node interweave(Node listA, Node listB) {
        Node result = new Node(listA.data);

        //listA: 1,2,3; listB: 5,4
        //listA.head: 1, listB.head: 5 -> result = 1,5
        //listA.head: 2, listB.head: 5 ->
        Node current = result;
        listA = listA.next;
        while (listA != null && listB != null) {
            current.next = new Node(listB.data);
            current.next.next = new Node(listA.data);
            listA = listA.next;
            listB = listB.next;
            current = current.next.next;
        }
        return result;

    }

    //1,2,3
    // 3,2,1:
    // head : 3, tail : 3 -> tail.next = head; tail.next.next = null -> 3,3,null
    // head : 2, tail : 3
    private static Node reversePart(Node head) {
        if (head.next == null) {
            return head;
        }
        Node tail = reversePart(head.next); //tail: 3
        head.next.next = head;              //head: 3
        head.next = null;
        return tail;
    }
// 1
//      2
//          3
//      2-3->3, 2->null 3
// 1->2->null, 1->2->3
    private static Node findMiddle(Node head) {
        int lenght = 0;
        for (Node node = head; node != null; node = node.next) {
            lenght++;
        }
        int middle = lenght / 2 + lenght % 2;
        Node middleNode = head;
        for (int i = 0; i < middle; i++) {
            middleNode = middleNode.next;
        }
        return middleNode;
    }

}

package leetcode.google.prepare;

public class RemoveZeroSublist {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode removeZeroSumSublists(ListNode node) {
        //scan from head, moving one item further
        //scan function will scan, when it finds sequence it can return ptr to last element.next or head
        //-- if scan returns pointer to head then do scan from next (head=head.next)
        //-- if scan returns some ptr then move head to that ptr
        // head = head.next
        // [1, -1]
        ListNode dummy = new ListNode(-1, node);
        ListNode head = dummy.next; //1
        ListNode prev = dummy; //-1 (d)
        while (head != null) {
            ListNode ptr = scanSequence(head);
            if (ptr == head) {
                prev = head;
                head = head.next;
            } else {
                prev.next = ptr; //-1 (d).next == null
                head = ptr; //null
            }
        }
        return dummy.next;
    }

    private static ListNode scanSequence(ListNode head) {
        int sum = head.val; //1
        ListNode ptr = head.next;//-1
        while (ptr != null) {
            sum += ptr.val; //0
            if (sum == 0) {
                return ptr.next; //null
            }
            ptr = ptr.next;
        }
        return head;
    }


}

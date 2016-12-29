package linkedLists;

/**
 * Created by Sergii_Zelenin on 12/29/2016.
 * https://codelab.interviewbit.com/problems/listcycle/
 */
public class ListCycle {
    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode firstp = head;
        ListNode secondp = head;
        boolean isCycle = false;

        while(firstp != null && secondp != null) {
            firstp = firstp.next;
            if (secondp.next == null) return null;
            secondp = secondp.next.next;
            if (firstp == secondp) { isCycle = true; break; }
        }

        if(!isCycle) return null;
        firstp = head;
        while( firstp != secondp) {
            firstp = firstp.next;
            secondp = secondp.next;
        }

        return firstp;


    }

    public static ListNode detectCycle_Endless(ListNode a) {
        ListNode firstp = a;
        ListNode secondp = null;
        //wrong!! first and second should start simultaneously. So when first is at head + 1 second should be at head + 2
        if (a.next!=null){
            secondp = a.next.next;
        }
        while (secondp != null && firstp!=secondp) {
            if (secondp.next!=null){
                secondp = secondp.next.next;
                firstp = firstp.next;
            }else{
                secondp = null;
            }
        }
        if (secondp == null) {
            return null;
        }
        firstp = a;
        while( firstp != secondp) {
            firstp = firstp.next;
            secondp = secondp.next;
        }
        return firstp;
    }

}

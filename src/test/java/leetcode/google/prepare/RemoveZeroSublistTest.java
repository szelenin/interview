package leetcode.google.prepare;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RemoveZeroSublistTest {
    @Test
    public void shouldRemoveTwoInMiddle() {
        //[1,2,-3,3,1]
        RemoveZeroSublist.ListNode list = buildList(new int[]{1, 2, -3, 3, 1});

        assertEquals("3, 1", toString(RemoveZeroSublist.removeZeroSumSublists(list)));
    }

    @Test
    public void shouldRemoveLeading() {
        RemoveZeroSublist.ListNode list = buildList(new int[]{1, -1, 2});

        assertEquals("2", toString(RemoveZeroSublist.removeZeroSumSublists(list)));
    }

    @Test
    public void shouldRemoveTailing() {
        RemoveZeroSublist.ListNode list = buildList(new int[]{2, 3, 1, -1});

        assertEquals("2, 3", toString(RemoveZeroSublist.removeZeroSumSublists(list)));
    }

    @Test
    public void shouldRemoveAll() {
        RemoveZeroSublist.ListNode list = buildList(new int[]{2, 3, -5});

        assertEquals("", toString(RemoveZeroSublist.removeZeroSumSublists(list)));
    }

    @Test
    public void shouldKeepSameList() {
        RemoveZeroSublist.ListNode list = buildList(new int[]{2, 3, -4});

        assertEquals("2, 3, -4", toString(RemoveZeroSublist.removeZeroSumSublists(list)));
    }

    @Test
    public void shouldHandleNullValue() {
        RemoveZeroSublist.ListNode list = buildList(null);

        assertEquals("", toString(RemoveZeroSublist.removeZeroSumSublists(list)));
    }

    @Test
    public void shouldKeepZeros() {
        RemoveZeroSublist.ListNode list = buildList(new int[]{0});

        assertEquals("0", toString(RemoveZeroSublist.removeZeroSumSublists(list)));
    }

    private RemoveZeroSublist.ListNode buildList(int[] nums) {
        if (nums == null) {
            return null;
        }

        RemoveZeroSublist.ListNode head = new RemoveZeroSublist.ListNode(nums[0]);
        RemoveZeroSublist.ListNode current = head;
        for (int i = 1; i < nums.length; i++) {
            current.next = new RemoveZeroSublist.ListNode(nums[i]);
            current = current.next;
        }
        return head;
    }

    private String toString(RemoveZeroSublist.ListNode list) {
        StringBuilder sb = new StringBuilder();
        while (list != null) {
            sb.append(list.val);
            if (list.next != null) {
                sb.append(", ");
            }
            list = list.next;
        }
        return sb.toString();
    }

}
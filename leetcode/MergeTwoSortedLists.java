// https://leetcode.com/problems/merge-two-sorted-lists/
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode merged;

        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null && l2 != null) {
            return l2;
        } else if (l1 != null && l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            merged = l1;
            l1 = l1.next;
        } else {
            merged = l2;
            l2 = l2.next;
        }
        ListNode current = merged;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if (l1 != null) {
            current.next = l1;
        } else if (l2 != null) {
            current.next = l2;
        }
        return merged;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

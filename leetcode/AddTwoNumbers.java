// https://leetcode.com/explore/interview/card/top-interview-questions-medium/107/linked-list/783/

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(-1);
        ListNode current = root;
        ListNode c1 = l1;
        ListNode c2 = l2;
        int carry = 0;

        while (true) {
            if (c1 == null && c2 == null) {
                break;
            }
            int a = c1 != null ? c1.val : 0;
            int b = c2 != null ? c2.val : 0;
            int sum = a + b + carry;
            carry = sum >= 10 ? 1 : 0;
            current.next = new ListNode(sum % 10);
            current = current.next;
            c1 = c1 != null ? c1.next: null;
            c2 = c2 != null ? c2.next : null;
        }
        if (carry == 1) {
            current.next = new ListNode(1);
        }
        return root.next;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    public ListNode plusOne(ListNode head) {
        head = reverse(head);
        int carry = 1;
        ListNode node = head;
        ListNode prev = null;

        while (node != null) {
            int sum = carry + node.val;
            node.val = sum % 10;
            carry = sum == 10 ? 1 : 0;
            prev = node;
            node = node.next;
        }

        if (carry == 1) {
            prev.next = new ListNode(1);
        }
        return reverse(head);
    }

    ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = new ListNode(head.next.val);
        newHead.next = head;
        newHead.next.next =
            swapPairs(head.next != null ? head.next.next : head.next);
        return newHead;
    }
}

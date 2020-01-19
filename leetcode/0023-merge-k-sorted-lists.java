/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        // use a PriorityQueue and then perform extract min
        PriorityQueue<ListNode> q = new PriorityQueue<>(
            (a, b) -> (a.val - b.val)
        );

        for (ListNode head : lists) {
            if (head != null) {
                q.add(head);
            }
        }

        if (q.isEmpty()) {
            return null;
        }

        ListNode head = new ListNode(0);
        ListNode cur = head;

        while (!q.isEmpty()) {
            ListNode node = q.poll();
            cur.next = node;
            if (node.next != null) {
                q.add(node.next);
            }
            cur = node;
        }
        return head.next;
    }
}

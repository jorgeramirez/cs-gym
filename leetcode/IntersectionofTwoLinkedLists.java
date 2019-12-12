// https://leetcode.com/explore/interview/card/top-interview-questions-medium/107/linked-list/785/
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 1) we compute the length of each list
        // 2) we skip nodes of the longest list
        // 3) we iterate until we find the shared node and return it (or we return null)
        // Time: O(n)
        // Space: O(1)

        int lenA = getLength(headA);
        int lenB = getLength(headB);
        ListNode longest = headA;
        ListNode shortest = headB;

        if (lenA > lenB) {
            longest = headA;
            shortest = headB;
        } else if (lenB > lenA) {
            longest = headB;
            shortest = headA;
        }

        for (int i = 0; i < Math.abs(lenB - lenA); i++) {
            longest = longest.next;
        }

        while (shortest != null && longest != null) {
            if (shortest != null && longest != null && shortest.equals(longest)) {
                return shortest;
            }
            shortest = shortest.next;
            longest = longest.next;
        }
        return null;
    }

    public int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            ++len;
        }
        return len;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}

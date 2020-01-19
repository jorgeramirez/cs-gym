/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/
class Solution {

    public Node flatten(Node head) {
        Node current = head;
        while (current != null) {
            if (current.child == null) {
                current = current.next;
                continue;
            }
            Node tmp = current.next;
            current.next = current.child;
            Node ctail = getTail(current.child);
            ctail.next = tmp;
            if (tmp != null) {
                tmp.prev = ctail;
            }
            current.next.prev = current;
            current.child = null;
            current = current.next;
        }
        return head;
    }

    Node getTail(Node head) {
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current;
    }
}

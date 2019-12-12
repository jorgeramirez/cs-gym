// https://leetcode.com/problems/lru-cache/
// The follow up question (only O(1) operations) is the hard version of the problem.

// Option #2: Time set O(1) get O(1)
// To improve this we can create a double-linked list to store the values of a key. And a hash map will allow us to
// quickly access (in O(1)) a node in the double-linked list.
// a head and back pointers will allow us to quick identify the front and back of the queue.
// so with this moving an element from the queue to the front (hit) is O(1). And get is also O(1).

import java.util.Hashtable;

public class LRUCacheOptimized {
    int capacity;
    Hashtable<Integer, Node> cache = new Hashtable<>();
    // recently used items are in the front.
    Node head = new Node(-1, -1);
    // least-recenlty used items are in the back
    Node tail = new Node(-1, -1);


    public LRUCacheOptimized(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        Node el = cache.get(key);
        detach(el);
        hit(el);
        return el.val;
    }

    public void put(int key, int value) {
        Node newEl = new Node(key, value);

        if (cache.containsKey(key)) {
            detach(cache.get(key));
        } else if (cache.size() == capacity) {
            pop();
        }
        hit(newEl);
        cache.put(key, newEl);
    }

    // disconnects the node
    void detach(Node el) {
        Node prev = el.prev;
        Node next = el.next;

        if (prev == null) {
            head.next = next;
        }

        if (next == null) {
            tail.prev = prev;
        }

        if (next != null) {
            next.prev = prev;
        }

        if (prev != null) {
            prev.next = next;
        }
    }

    // updates head
    void hit(Node el) {
        el.prev = null;

        if (head.next != null) {
            el.link(head.next);
        }
        head.next = el;

        if (tail.prev == null) {
            tail.prev = head.next;
        }
    }

    // updates tail and removes the key
    void pop() {
        Node el = tail.prev;
        Node newTail = el.prev;

        if (newTail != null) {
            newTail.next = null;
            tail.prev = newTail;
        } else {
            tail.prev = null;
        }
        cache.remove(el.key);
    }


    static class Node {
        Node prev;
        Node next;
        int key;
        int val;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        void link(Node other) {
            this.next = other;
            other.prev = this;
        }
    }


    public static void main(String[] args) {
//        LRUCacheOptimized cache = new LRUCacheOptimized(2);
//        cache.put(1, 1);
//        cache.put(2, 2);
//        System.out.println(cache.get(1));       // returns 1
//        cache.put(3, 3);    // evicts key 2
//        System.out.println(cache.get(2));       // returns -1 (not found)
//        cache.put(4, 4);    // evicts key 1
//        System.out.println(cache.get(1));       // returns -1 (not found)
//        System.out.println(cache.get(3));       // returns 3
//        System.out.println(cache.get(4));       // returns 4
//
//
//        LRUCacheOptimized c2 = new LRUCacheOptimized(1);
//        c2.put(2, 1);
//        System.out.println(c2.get(2));
//        c2.put(3, 2);
//        System.out.println(c2.get(2));
//        System.out.println(c2.get(1));

        LRUCacheOptimized c3 = new LRUCacheOptimized(2);
        System.out.println(c3.get(2)); // -1
        c3.put(2, 6);
        System.out.println(c3.get(1)); // -1
        c3.put(1, 5);
        c3.put(1, 2);
        System.out.println(c3.get(1)); // 2
        System.out.println(c3.get(2)); // 6

    }
}

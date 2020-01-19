import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;

public class LRUCache {
    int capacity;
    Hashtable<Integer, Node> cache = new Hashtable<>();

    // recently used items are in the front.
    Node head = new Node(-1, -1);

    // least-recenlty used items are in the back
    Node tail = new Node(-1, -1);

    public LRUCache(int capacity) {
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
}

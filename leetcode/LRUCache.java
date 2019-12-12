// https://leetcode.com/problems/lru-cache/
// The follow up question (only O(1) operations) is the hard version of the problem.

// Option #1. Time: set O(n) get O(n)
// 1) use a queue to store the keys of items we insert (this que define the next item to invalidate)
// 2) use a hashtable for key => values
// 3) a get removes the item from the queue and enqueues it again
//    if the key does not exists then it just enqueue de key
// 4) polls and add a new key to the queue

// Option #2: Time set O(1) get O(1)
// To improve the above we could use a double linked list for the queue and a hash table to map from key to Node in the que
// so with this moving an element from the queue to the front (hit) is O(1). And get is also O(1).
import java.util.LinkedList;
import java.util.Hashtable;
import java.util.Queue;
public class LRUCache {
    int capacity;
    Hashtable<Integer, Integer> cache = new Hashtable<>();
    Queue<Integer> queue = new LinkedList<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        queue.remove(key);
        queue.add(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            queue.remove(key);
        }

        if (queue.size() == capacity) {

            int invalidKey = queue.poll();

            if (cache.containsKey(invalidKey)) {
                cache.remove(invalidKey);
            }
        }
        queue.add(key);
        cache.put(key, value);
    }
}

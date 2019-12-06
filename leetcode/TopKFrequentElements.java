import java.util.*;

// https://leetcode.com/problems/top-k-frequent-elements/

/**
 * Here we rely on hashmaps and a heap. The heap is a tree-based data structure that is an efficient implementation
 * of the priority queue. The property of a max heap is that for a parent node P and child C, the value of P (the key)
 * is greater than the value of C (the opposite for a min heap).
 *
 * extractMax is O(log n)
 * getMax is O(1) since the root is the max value.
 */

public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        // 1) we create a frequency table    O(n)
        // 2) we create a max heap  O(nlog(n)) -> adding an element to a heap is O(log(n))
        // 3) we extract k elements from the max heap O(k log(n))
        // Time O(nlog(n))
        // Space O(n)
        HashMap<Integer, Integer> freq = new HashMap<>();
        // we pass the comparator to build a max heap (notice the negative in front)
        PriorityQueue<Integer> heap = new PriorityQueue<>((num1, num2) -> -(freq.get(num1) - freq.get(num2)));
        List<Integer> result = new ArrayList<>();

        // 1)
        for(int i = 0; i < nums.length; i++) {
            if(freq.containsKey(nums[i])) {
                freq.put(nums[i], freq.get(nums[i]) + 1);
            }else{
                freq.put(nums[i], 1);
            }
        }

        // 2)
        freq.forEach((number, count) -> {
            heap.add(number);
        });

        // 3)
        for(int i = 0; i < k; i++) {
            result.add(heap.poll());
        }
        return result;
    }

    public static void main(String[] args) {
        TopKFrequentElements s = new TopKFrequentElements();
        List<Integer> out = s.topKFrequent(new int[]{1,1,1,2,2,3}, 2);
        out.stream().forEach(i -> {
            System.out.print(i + " ");
        });
        System.out.println();
        out = s.topKFrequent(new int[]{1,2,3,4,5}, 5);
        out.stream().forEach(i -> {
            System.out.print(i + " ");
        });
    }
}

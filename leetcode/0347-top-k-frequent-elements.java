class Solution {

    public List<Integer> topKFrequent(int[] nums, int k) {
        // 1) we create a frequency table    O(n)
        // 2) we create a max heap  O(nlog(n)) -> adding an element to a heap is O(log(n))
        // 3) we extract k elements from the max heap O(k log(n))
        // Time O(nlog(n))
        // Space O(n)
        HashMap<Integer, Integer> freq = new HashMap<>();

        // we pass the comparator to build a max heap
        PriorityQueue<Integer> heap = new PriorityQueue<>(
            (num1, num2) -> -(freq.get(num1) - freq.get(num2))
        );
        List<Integer> result = new ArrayList<>();

        // 1)
        for (int i = 0; i < nums.length; i++) {
            if (freq.containsKey(nums[i])) {
                freq.put(nums[i], freq.get(nums[i]) + 1);
            } else {
                freq.put(nums[i], 1);
            }
        }

        // 2)
        freq.forEach(
            (number, count) -> {
                heap.add(number);
            }
        );

        // 3)
        for (int i = 0; i < k; i++) {
            result.add(heap.poll());
        }
        return result;
    }
}

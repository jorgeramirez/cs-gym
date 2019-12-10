import java.util.Hashtable;

// https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/549/
// https://leetcode.com/problems/single-number/
public class SingleNumber {
    public int singleNumber(int[] nums) {
        // 1) use a hash table to store the keys we found twice (true)
        // 2) return the element with value false in the hash table.
        // Time: O(n)
        // space: O(n)
        Hashtable<Integer, Boolean> dups = new Hashtable<>();

        for (int i = 0; i < nums.length; i++) {
            if (dups.containsKey(nums[i])) {
                dups.put(nums[i], true);
            } else {
                dups.put(nums[i], false);
            }
        }

        Integer unique = null;
        for (int i = 0; i < nums.length; i++) {
            if (!dups.get(nums[i])) {
                unique = nums[i];
                break;
            }
        }
        return unique;
    }

    public static void main(String[] args) {
        SingleNumber s = new SingleNumber();

        System.out.println(s.singleNumber(new int[]{4, 1, 2, 1, 2}));

        System.out.println(s.singleNumber(new int[]{2, 1, 3, 3, 1}));
    }
}

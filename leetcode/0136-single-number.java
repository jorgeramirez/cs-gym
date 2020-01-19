import java.util.Hashtable;

class Solution {

    public int singleNumber(int[] nums) {
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
}

class Solution {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> complements = new HashMap<>();
        int[] result = new int[] {};

        for (int i = 0; i < nums.length; i++) {
            int delta = target - nums[i];

            if (complements.containsKey(delta)) {
                result = new int[] { complements.get(delta), i };
                break;
            }
            complements.put(nums[i], i);
        }
        return result;
    }
}

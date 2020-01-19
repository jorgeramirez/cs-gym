class Solution {

    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int n = nums.length;
        int[] sums = new int[n];
        sums[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int rangeSum = sums[j] - sums[i] + nums[i];
                if (rangeSum == k || (k != 0 && rangeSum % k == 0)) {
                    return true;
                }
            }
        }
        return false;
    }
}

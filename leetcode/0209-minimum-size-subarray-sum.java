class Solution {

    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] sums = new int[nums.length];
        sums[0] = nums[0];

        for (int i = 1; i < n; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }

        if (sums[n - 1] < s) {
            return 0;
        }

        int minLen = Integer.MAX_VALUE;

        for (int L = 0; L < n; L++) {
            if (nums[L] >= s) {
                return 1;
            }

            for (int R = L + 1; R < n; R++) {
                int rangeSum = nums[L] + sums[R] - sums[L];
                int rangeLen = R - L + 1;
                if (rangeSum >= s) {
                    minLen = Math.min(minLen, rangeLen);
                    break;
                }
            }
        }
        return minLen;
    }
}

class Solution {

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int dpMin = nums[0];
        int dpMax = nums[0];
        int max = dpMax;

        for (int i = 1; i < nums.length; i++) {
            int prevDpMin = dpMin;
            int prevDpMax = dpMax;

            dpMax =
                Math.max(
                    Math.max(prevDpMax * nums[i], nums[i]),
                    prevDpMin * nums[i]
                );
            dpMin =
                Math.min(
                    Math.min(prevDpMax * nums[i], nums[i]),
                    prevDpMin * nums[i]
                );

            max = Math.max(max, Math.max(dpMax, dpMin));
        }
        return max;
    }
}

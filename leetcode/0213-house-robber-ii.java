class Solution {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // we start with a robbery
        // we should run this formula for i=1 .. i=n-1
        int n = nums.length;
        int rob = nums[0];
        int noRob = 0;

        for (int i = 1; i < n - 1; i++) {
            int prevRob = rob;
            rob = noRob + nums[i];
            noRob = Math.max(noRob, prevRob);
        }
        int maxOne = Math.max(rob, noRob);

        // we don't start with a robbery
        // we run the above for i=1 .. n
        rob = 0;
        noRob = 0;

        for (int i = 1; i < n; i++) {
            int prevRob = rob;
            rob = noRob + nums[i];
            noRob = Math.max(noRob, prevRob);
        }
        int maxTwo = Math.max(rob, noRob);
        return Math.max(maxOne, maxTwo);
    }
}

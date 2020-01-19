class Solution {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int rob = nums[0];
        int noRob = 0;

        // one pass and use formula
        //rob[i] =  noRob[i-1] + nums[i]
        //noRob[i] = max(rob[i-1], noRob[i-1])
        for (int i = 1; i < nums.length; i++) {
            int robPrevDay = rob;
            rob = noRob + nums[i];
            noRob = Math.max(robPrevDay, noRob);
        }
        return Math.max(rob, noRob);
    }
}

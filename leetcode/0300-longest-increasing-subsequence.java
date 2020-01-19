class Solution {

    // public int lengthOfLIS(int[] nums) {
    // 	if(nums.length == 0) { return 0; }
    // int[] dp = new int[nums.length];
    // dp[0]=1;
    // int answer = 1;
    // for(int i = 1; i < nums.length; i++) {
    // 	int max = 0;
    // 	for(int j = 0; j < i; j++) {
    // 		if(nums[i] > nums[j]) {
    // 			max = Math.max(max, dp[j]);
    // }
    // }
    // dp[i] = max + 1;
    // answer = Math.max(answer, dp[i]);
    // }
    // return answer;
    // }
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int answer = dp[0];
        for (int i = 1; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            answer = Math.max(answer, dp[i]);
        }
        return answer;
    }
}

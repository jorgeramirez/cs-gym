class Solution {

    // public int[] productExceptSelf(int[] nums) {
    // 	int[] preffix = new int[nums.length];
    //     int total = 1;
    // 	for(int i = 0; i < nums.length; i++) {
    // 		preffix[i] = total * nums[i];
    // total = preffix[i];
    // }
    // 	int[] suffix = new int[nums.length];
    // 	total = 1;
    // for(int i = nums.length -1; i >= 0; i--){
    // 	suffix[i] = total * nums[i];
    // 	total = suffix[i];
    // }
    // int[] result = new int[nums.length];
    // for(int i = 1; i < nums.length - 1; i++) {
    // 	result[i] = preffix[i-1] * suffix[i+1];
    // }
    // result[0] = suffix[1];
    // result[nums.length-1] = preffix[nums.length - 2];
    // return result;
    // }
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int total = 1;

        for (int i = 0; i < nums.length; i++) {
            result[i] = total * nums[i];
            total = result[i];
        }
        result[nums.length - 1] = result[nums.length - 2];
        total = nums[nums.length - 1];

        for (int i = nums.length - 2; i > 0; i--) {
            result[i] = result[i - 1] * total;
            total *= nums[i];
        }
        result[0] = total;
        return result;
    }
}

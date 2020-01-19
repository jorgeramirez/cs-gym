class Solution {

    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        int[] ans = null;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                ans = new int[] { i + 1, j + 1 };
                break;
            } else if (sum > target) {
                --j;
            } else {
                i++;
            }
        }
        return ans;
    }
}

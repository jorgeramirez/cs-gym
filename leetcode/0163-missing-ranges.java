class Solution {

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ranges = new ArrayList<>();
        long low = lower;
        long up = upper;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > low) {
                long left = low;
                long right = nums[i] - 1;
                if (left != right) {
                    ranges.add(left + "->" + right);
                } else {
                    ranges.add(left + "");
                }
            }
            low = (long) nums[i] + 1;
        }
        if (low < up) {
            ranges.add(low + "->" + up);
        } else if ((nums.length == 0 || nums[nums.length - 1] != up)) {
            ranges.add(low + "");
        }
        return ranges;
    }
}

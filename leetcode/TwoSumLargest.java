import java.util.HashMap;

public class TwoSumLargest {
    public int[] twoSum(int[] nums, int target) {
        int[] maxPair = null;
        target = target - 30;
        HashMap<Integer, Integer> complements = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (complements.containsKey(nums[i])) {
                if (maxPair != null) {
                    int[] currentPair = new int[]{complements.get(nums[i]), i};
                    int currentPairMax = Math.max(nums[currentPair[0]], nums[currentPair[1]]);
                    int maxPairMax = Math.max(nums[maxPair[0]], nums[maxPair[1]]);

                    if (currentPairMax > maxPairMax) {
                        maxPair = currentPair;
                    }
                } else {
                    maxPair = new int[]{complements.get(nums[i]), i};
                }
            } else {
                int delta = target - nums[i];
                complements.put(delta, i);
            }
        }
        return maxPair;
    }

    public static void main(String[] args) {
        TwoSumLargest s = new TwoSumLargest();
        int[] out = s.twoSum(new int[]{20, 50, 40, 25, 30, 10}, 90);
        System.out.println("[" + out[0] + "," + out[1] + "]");
    }
}

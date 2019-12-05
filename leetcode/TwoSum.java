import java.util.HashMap;

/**
 * Time: O(n)
 * Space: O(n)
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> complements = new HashMap<>();
        int[] result = new int[] {};

        for(int i = 0; i < nums.length; i++) {
            int delta = target -  nums[i];

            if(complements.containsKey(delta)) {
                result = new int[] {complements.get(delta), i};
                break;
            }
            complements.put(nums[i], i);
        }
        return result;
    }

    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        int[] numbers = new int[] {2, 7, 11, 15};
        int[] result = ts.twoSum(numbers, 9);
        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }
}

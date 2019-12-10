// https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/646/
public class RotateArray {

    public void rotate(int[] nums, int k) {
        // Option #1 Time: O(n) Space: O(n)
        // 1) compute new index for every element as (i + k) % nums.length
        // 2) create a new array with the same size of input
        // 3) iterate over nums and place the element in the new array according to the new position.
        //rotateV1(nums, k);

        // Option #2 Time: O(n) Space: O(1)
        // Basically the blocks that "overflow" with those that do not. Or in other words, we put k elements form the back in the front.
        // we can implement a reverse function and do the following:
        // 1) reverse the entire array // to get the elements from the back in the front (in reverse order though).
        // 2) reverse the first k  // we undo our reverse order for the first k (this is our block from the back).
        // 3) reverse the last k  // we undo our reverse order for the las k (this is our block from the front).
        rotateV2(nums, k);
    }

    public void rotateV1(int[] nums, int k) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = result[i];
        }
    }

    public void rotateV2(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        int tmp;
        while (start < end) {
            tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            ++start;
            --end;
        }
    }

    public static void printArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        RotateArray solution = new RotateArray();
        int[] nums = new int[]{1, 2, 3, 4, 5};
        solution.rotate(nums, 3); // should print [3, 4, 5, 1 ,2]
        printArray(nums);

        nums = new int[]{1, 2, 3, 4};
        solution.rotate(nums, 2);
        printArray(nums); // should print [3, 4, 1, 2]

        nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        solution.rotate(nums, 3);
        printArray(nums); // should print [5,6,7,1,2,3,4]

        nums = new int[]{-1, -100, 3, 99};
        solution.rotate(nums, 3);
        printArray(nums); // should print [-100,3,99,-1]
    }
}

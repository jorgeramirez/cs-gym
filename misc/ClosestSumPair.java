package misc;

// from https://www.youtube.com/watch?v=GBuHSRDGZBY&t=920s
// given two arrays of integers and a target number
// return the pair of elements (one from each array) that is closest to the sum
public class ClosestSumPair {
    public int[] solve(int[] nums1, int[] nums2, int target) {
        // #1 brute force is O(n^2)
        // #2 do a check_sum function in O(n) and just increment a gap in loop (target + gap and target - gap) until we reach a solution.
        //    this would be O(p n) where p is the number of gaps we tried.
        // #3 Sort both array and then search the solutions is a stair-like shape (starting from the last element of the first row).

        return null;
    }

    public static void main(String[] args) {
        ClosestSumPair csp = new ClosestSumPair();
        int[] out = csp.solve(new int[]{-1, 3, 8, 2, 9, 5}, new int[]{4, 1, 2, 10, 5, 20}, 24);

        int[] b1 = {7, 4, 1, 10};
        int[] b2 = {4, 5, 8, 7};
        int bTarget = 13;
        // closestSumPair(b1, b2, bTarget) should return {4, 8}, {7, 7}, {7, 5}, or {10, 4}

        int[] c1 = {6, 8, -1, -8, -3};
        int[] c2 = {4, -6, 2, 9, -3};
        int cTarget = 3;
        // closestSumPair(c1, c2, cTarget) should return {-1, 4} or {6, -3}

        int[] d1 = {19, 14, 6, 11, -16, 14, -16, -9, 16, 13};
        int[] d2 = {13, 9, -15, -2, -18, 16, 17, 2, -11, -7};
        int dTarget = -15;
        // closestSumPair(d1, d2, dTarget) should return {-16, 2}, {-9, -7}
    }
}

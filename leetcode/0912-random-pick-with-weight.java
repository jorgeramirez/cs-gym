class Solution {
    int total = 0;
    int[] sums;
    Random rand = new Random();

    public Solution(int[] w) {
        sums = new int[w.length];

        for (int i = 0; i < w.length; i++) {
            total += w[i];
            sums[i] = total;
        }
    }

    public int pickIndex() {
        int target = (int) (Math.random() * total); // rand.nextInt(total);
        int start = 0;
        int end = sums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target >= sums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
}

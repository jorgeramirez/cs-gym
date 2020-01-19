class Solution {
    HashMap<Integer, Integer> memo = new HashMap<>();

    public int numDecodings(String s) {
        return numWays(s.toCharArray(), 0);
    }

    int numWays(char[] digits, int index) {
        if (index == digits.length) {
            return 1;
        }
        if (memo.containsKey(index)) {
            return memo.get(index);
        }
        int singleCombination = 0;
        int pairCombination = 0;
        if (digits[index] != '0') {
            singleCombination = numWays(digits, index + 1);
        }

        if (index < digits.length - 1) {
            if (
                digits[index] == '1' ||
                (digits[index] == '2' && digits[index + 1] <= '6')
            ) {
                pairCombination = numWays(digits, index + 2);
            }
        }
        memo.put(index, singleCombination + pairCombination);
        return memo.get(index);
    }
}

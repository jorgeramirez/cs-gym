class Solution {

    public int calculateTime(String keyboard, String word) {
        int sum = 0;
        int cur = 0;
        for (int i = 0; i < word.length(); i++) {
            int target = keyboard.indexOf(word.charAt(i));
            sum += Math.abs(target - cur);
            cur = target;
        }
        return sum;
    }
}

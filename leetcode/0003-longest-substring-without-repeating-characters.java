import java.util.HashSet;
import java.util.Set;

class Solution {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> chars = new HashSet<>();
        int i = 0;
        int start = i;
        int max = 0;
        int current = 0;

        while (i < s.length()) {
            if (chars.contains(s.charAt(i))) {
                chars = new HashSet<>();
                max = Math.max(current, max);
                i = start + 1;
                start = i;
                current = 0;
            } else {
                chars.add(s.charAt(i));
                ++i;
                ++current;
            }
        }
        max = Math.max(current, max);
        return max;
    }
}

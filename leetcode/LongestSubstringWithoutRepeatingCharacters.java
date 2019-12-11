import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/779/
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        // We do a sliding window here and use a hash set to check whether a char exists in the current window.
        // Time: O(2n) so O(n) because in the worst case we visit each element twice.
        // Space: O(min(m, n)) n is the length of the string and m is alphatbet.
        //        So min(m, n) is an upper bound for the size of the hash set.
        Set<Character> chars = new HashSet<>();
        int i = 0;
        int j = i;
        int max = 0;

        while (j < s.length()) {
            if (chars.contains(s.charAt(j))) {
                chars = new HashSet<>();
                ++i;
                j = i;
            } else {
                chars.add(s.charAt(j));
                ++j;
                max = Math.max(j - i, max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters s = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(s.lengthOfLongestSubstring("abcddabcdefgh"));
    }
}

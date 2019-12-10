import java.util.Hashtable;
// https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/881/
public class FirstUniqueCharString {
    public int firstUniqChar(String s) {
        Hashtable<Character, Integer> freq = new Hashtable<>();

        for (int i = 0; i < s.length(); i++) {
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (freq.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}

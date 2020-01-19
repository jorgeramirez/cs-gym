import java.util.Arrays;
import java.util.HashMap;

class Solution {

    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> (a.length() - b.length()));
        int longest = 0;
        HashMap<String, Integer> dp = new HashMap<>();
        for (String w : words) {
            if (dp.containsKey(w)) {
                continue;
            }
            dp.put(w, 1);
            for (int i = 0; i < w.length(); i++) {
                StringBuilder sb = new StringBuilder(w);
                String next = sb.deleteCharAt(i).toString();
                if (dp.containsKey(next) && dp.get(next) + 1 > dp.get(w)) {
                    dp.put(w, dp.get(next) + 1);
                }
            }
            longest = Math.max(longest, dp.get(w));
        }
        return longest;
    }
}

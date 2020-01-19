import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Solution {

    public String getHint(String secret, String guess) {
        HashMap<Character, Integer> sFreq = new HashMap<>();
        HashMap<Character, Integer> gFreq = new HashMap<>();
        int bulls = 0, cows = 0;
        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s == g) {
                ++bulls;
            } else {
                sFreq.put(s, sFreq.getOrDefault(s, 0) + 1);
                gFreq.put(g, gFreq.getOrDefault(g, 0) + 1);
            }
        }
        for (char d : sFreq.keySet()) {
            if (!gFreq.containsKey(d)) {
                continue;
            }
            cows += Math.min(sFreq.get(d), gFreq.get(d));
        }
        return bulls + "A" + cows + "B";
    }
}

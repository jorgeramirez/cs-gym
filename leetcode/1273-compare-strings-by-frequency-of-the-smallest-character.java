import java.util.Arrays;
import java.util.HashMap;

class Solution {

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] fq = applyFreq(queries);
        int[] fw = applyFreq(words);
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.sort(fw);
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (map.containsKey(fq[i])) {
                ans[i] = map.get(fq[i]);
                continue;
            }
            int j;
            for (j = words.length - 1; j >= 0; j--) {
                if (fq[i] >= fw[j]) {
                    break;
                }
            }
            ans[i] = words.length - 1 - j;
            map.put(fq[i], ans[i]);
        }
        return ans;
    }

    int f(String source) {
        char[] ch = source.toCharArray();
        Arrays.sort(ch);
        int count = 0;
        for (char c : source.toCharArray()) {
            if (c == ch[0]) {
                ++count;
            }
        }
        return count;
    }

    int[] applyFreq(String[] sources) {
        int[] fs = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            fs[i] = f(sources[i]);
        }
        return fs;
    }
}

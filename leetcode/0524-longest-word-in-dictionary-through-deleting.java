class Solution {

    public String findLongestWord(String s, List<String> d) {
        if (d == null || d.isEmpty()) {
            return "";
        }
        Collections.sort(d);
        int maxLen = 0;
        String maxSubSeq = "";
        for (String word : d) {
            if (isSubSequence(s, word) && word.length() > maxLen) {
                maxLen = word.length();
                maxSubSeq = word;
            }
        }
        return maxSubSeq;
    }

    boolean isSubSequence(String s, String w) {
        int i = 0;
        int j = 0;

        while (i < w.length() && j < s.length()) {
            if (w.charAt(i) == s.charAt(j)) {
                ++j;
                ++i;
            } else {
                ++j;
            }
        }

        return i == w.length();
    }
}

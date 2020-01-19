class Solution {
    HashMap<String, Boolean> memo = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        for (String word : wordDict) {
            if (s.equals(word)) {
                return true;
            }
            if (s.startsWith(word)) {
                String left = s.substring(word.length());
                boolean canBreak = wordBreak(left, wordDict);
                memo.put(left, canBreak);
                if (canBreak) {
                    return true;
                }
            }
        }
        return false;
    }
}

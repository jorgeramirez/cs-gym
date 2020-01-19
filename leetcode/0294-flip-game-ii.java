class Solution {
    HashMap<String, Boolean> dp = new HashMap<>();

    public boolean canWin(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        return backtrack(s);
    }

    // returns who wins
    boolean backtrack(String state) {
        if (dp.containsKey(state)) {
            return dp.get(state);
        }
        List<String> nextMoves = generatePossibleNextMoves(state);
        for (String move : nextMoves) {
            boolean win = backtrack(move);
            if (!win) {
                dp.put(state, true);
                return true;
            }
        }
        dp.put(state, false);
        return false;
    }

    public List<String> generatePossibleNextMoves(String s) {
        List<String> states = new ArrayList<>();
        for (int i = 1; i < s.length(); i++) {
            char ch1 = s.charAt(i - 1);
            char ch2 = s.charAt(i);
            if (ch1 != ch2 || ch1 == '-') {
                continue;
            }
            StringBuilder sb = new StringBuilder(s);
            sb.setCharAt(i, '-');
            sb.setCharAt(i - 1, '-');
            states.add(sb.toString());
        }
        return states;
    }
}

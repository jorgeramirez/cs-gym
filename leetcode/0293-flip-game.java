class Solution {

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

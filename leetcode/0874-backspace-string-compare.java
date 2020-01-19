class Solution {

    public boolean backspaceCompare(String S, String T) {
        String sCleaned = process(S);
        String tCleaned = process(T);
        return sCleaned.equals(tCleaned);
    }

    public String process(String src) {
        StringBuilder sb = new StringBuilder();
        for (Character ch : src.toCharArray()) {
            if (ch == '#') {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                continue;
            }
            sb.append(ch);
        }
        return sb.toString();
    }
}

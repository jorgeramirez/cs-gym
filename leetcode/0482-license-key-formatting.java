class Solution {

    public String licenseKeyFormatting(String S, int K) {
        String src = S.toUpperCase();
        StringBuilder sb = new StringBuilder();
        int gSize = 0;

        for (int i = src.length() - 1; i >= 0; i--) {
            char ch = src.charAt(i);
            if (ch == '-') {
                continue;
            }

            if (gSize == K) {
                sb.append("-");
                gSize = 0;
            }
            sb.append(ch);
            ++gSize;
        }
        sb = sb.reverse();
        return sb.toString();
    }
}

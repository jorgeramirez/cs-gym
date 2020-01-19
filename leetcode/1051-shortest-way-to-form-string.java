class Solution {

    public int shortestWay(String source, String target) {
        int c = 0;
        while (target.length() > 0) {
            int i = 0;
            int j = 0;
            for (; i < source.length(); i++) {
                char s = source.charAt(i);
                char t = target.charAt(j);
                if (s == t) {
                    ++j;
                }
                if (j == target.length()) {
                    break;
                }
            }
            if (i == source.length() && j == 0) {
                return -1;
            }
            ++c;
            target = target.substring(j);
        }
        return c;
    }
}

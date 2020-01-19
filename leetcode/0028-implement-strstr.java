class Solution {

    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        int i = 0;
        int j = 0;

        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                ++i;
                ++j;

                if (j == needle.length()) {
                    return i - needle.length();
                }
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        return -1;
    }
}

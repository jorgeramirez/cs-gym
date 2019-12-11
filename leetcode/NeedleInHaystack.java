// https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/885/
public class NeedleInHaystack {
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

    public static void main(String[] args) {
        NeedleInHaystack s = new NeedleInHaystack();
        System.out.println(s.strStr("hello", "ll")); // should print 2
        System.out.println(s.strStr("aaaaa", "bba")); // should print -1
        System.out.println(s.strStr("mississippi", "issipi")); // should print -1
        System.out.println(s.strStr("mississippi", "issip")); // should print 4
        System.out.println(s.strStr("a", "a")); // should print 4
    }
}

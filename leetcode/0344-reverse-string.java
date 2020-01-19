class Solution {

    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        char tmp;
        while (start < end) {
            tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            ++start;
            --end;
        }
    }
}

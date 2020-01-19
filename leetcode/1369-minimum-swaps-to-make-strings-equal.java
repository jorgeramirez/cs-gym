import java.util.ArrayList;
import java.util.List;

class Solution {

    public int minimumSwap(String s1, String s2) {
        int xy = 0;
        int yx = 0;
        if (s1.equals(s2)) {
            return 0;
        }

        for (int i = 0; i < s1.length(); i++) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            if (ch1 == 'x' && ch2 == 'y') {
                ++xy;
            } else if (ch1 == 'y' && ch2 == 'x') {
                ++yx;
            }
        }
        int res = 0;
        if (xy > 0) {
            if (xy % 2 == 0) {
                res = xy / 2;
                xy = 0;
            } else {
                res = (xy - 1) / 2;
                xy = 1;
            }
        }

        if (yx > 0) {
            if (yx % 2 == 0) {
                res += yx / 2;
                yx = 0;
            } else {
                res += (yx - 1) / 2;
                yx = 1;
            }
        }
        if (xy + yx == 1) {
            return -1;
        } else if (xy + yx == 2) {
            res += 2;
        }
        return res;
    }
}
